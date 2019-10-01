package com.abbyy.service;

import java.util.Arrays;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbyy.client.ClientSettings;
import com.abbyy.formatter.NliFormat;

@Service
public class AbbyyOcrService {

	@Autowired
	private Client restClient;

	@Autowired
	private XmlToJsonService xmlToJsonService;

	public NliFormat AbbyyOcrProcessor(String[] args) {

		// String[] args = { "recognize", "/home/harkesh/Desktop/12.png",
		// "/home/harkesh/Desktop/rs.xml" };

		System.out.println("Process documents using ABBYY Cloud OCR SDK.\n");

		if (!checkAppId()) {
			return null;
		}

		if (args.length < 2) {
			displayHelp();
			return null;
		}

		ClientSettings.setupProxy();

		restClient = new Client();
		// replace with 'https://cloud-eu.ocrsdk.com' to enable secure connection
		// replace with 'https://cloud-westus.ocrsdk.com' if your application is created
		// in US location
		restClient.serverUrl = "http://cloud-eu.ocrsdk.com/";
		restClient.applicationId = ClientSettings.APPLICATION_ID;
		restClient.password = ClientSettings.PASSWORD;

		// String[] com = {"java TestApp recognize 12.png 12resulttest.txt"};
		String[] args2 = args;
		// System.out.println(args[0]);

		Vector<String> argList = new Vector<String>(Arrays.asList(args));

		// Select processing mode
		String mode = args[0];
		argList.remove(0);

		try {
			if (mode.equalsIgnoreCase("recognize")) {
				return performRecognition(argList);
			} else {
				System.out.println("Unknown mode: " + mode);
				return null;
			}
		} catch (Exception e) {
			System.out.println("Exception occured:" + e.getMessage());
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Check that user specified application id and password.
	 * 
	 * @return false if no application id or password
	 */
	private boolean checkAppId() {
		String appId = ClientSettings.APPLICATION_ID;
		String password = ClientSettings.PASSWORD;
		if (appId.isEmpty() || password.isEmpty()) {
			System.out.println("Error: No application id and password are specified.");
			System.out.println("Please specify them in ClientSettings.java.");
			return false;
		}
		return true;
	}

	private void displayHelp() {
		System.out.println("This program is able to recognize:\n" + "\n"
				+ "1. Single- and multipage documents and convert them to txt, xml, pdf and other formats.\n"
				+ "  java TestApp recognize testImage.jpg result.xml\n"
				+ "  java TestApp recognize page1.jpg page2.jpg page3.jpg result.pdf --lang=French,Spanish\n" + "\n"
				+ "2. Business cards to vCard, xml and csv\n" + "  java TestApp busCard image.jpg result.xml\n" + "\n"
				+ "3. Printed and handprinted text snippets\n" + "  java TestApp textField image.jpg result.xml\n"
				+ "\n" + "4. Barcodes\n" + "  java TestApp barcode image.jpg result.xml\n" + "\n"
				+ "5. Many different snippets on document\n"
				+ "  java TestApp processFields image1.jpg image2.jpg image3.tif settings.xml result.xml\n" + "\n"
				+ "6. Machine-Readable Zones (MRZ) of Passports, ID cards, Visas and other official documents\n"
				+ "  java TestApp MRZ image.jpg result.xml\n" + "\n" + "7. Receipts\n"
				+ "  java TestApp receipt image.jpg result.xml\n" + "\n" + "For detailed help, call\n"
				+ "  java TestApp help <mode>\n"
				+ "where <mode> is one of: recognize, busCard, textField, barcode, checkmark, processFields, MRZ, receipt");
	}

	/**
	 * Parse command line and recognize one or more documents.
	 */
	private NliFormat performRecognition(Vector<String> argList) throws Exception {
		String language = CmdLineOptions.extractRecognitionLanguage(argList);
		String outputPath = argList.lastElement();
		argList.remove(argList.size() - 1);
		// argList now contains list of source images to process

		ProcessingSettings.OutputFormat outputFormat = outputFormatByFileExt(outputPath);

		ProcessingSettings settings = new ProcessingSettings();
		settings.setLanguage(language);

		settings.setOutputFormat(outputFormat);

		Task task = null;
		if (argList.size() == 1) {
			System.out.println("Uploading file..");
			task = restClient.processImage(argList.elementAt(0), settings);

		} else if (argList.size() > 1) {

			// Upload images via submitImage and start recognition with
			// processDocument
			for (int i = 0; i < argList.size(); i++) {
				System.out.println(String.format("Uploading image %d/%d..", i + 1, argList.size()));
				String taskId = null;
				if (task != null) {
					taskId = task.Id;
				}

				Task result = restClient.submitImage(argList.elementAt(i), taskId);
				if (task == null) {
					task = result;
				}
			}
			task = restClient.processDocument(task.Id, settings);

		} else {
			System.out.println("No files to process.");
			return null;
		}

		return waitAndDownloadResult(task, outputPath);
	}

	/**
	 * Extract output format from extension of output file.
	 */
	private ProcessingSettings.OutputFormat outputFormatByFileExt(String filePath) {
		int extIndex = filePath.lastIndexOf('.');
		if (extIndex < 0) {
			System.out.println("No file extension specified. Plain text will be used as output format.");
			return ProcessingSettings.OutputFormat.txt;
		}
		String ext = filePath.substring(extIndex).toLowerCase();
		if (ext.equals(".txt")) {
			return ProcessingSettings.OutputFormat.txt;
		} else if (ext.equals(".xml")) {
			return ProcessingSettings.OutputFormat.xml;
		} else if (ext.equals(".pdf")) {
			return ProcessingSettings.OutputFormat.pdfSearchable;
		} else if (ext.equals(".docx")) {
			return ProcessingSettings.OutputFormat.docx;
		} else if (ext.equals(".rtf")) {
			return ProcessingSettings.OutputFormat.rtf;
		} else {
			System.out.println("Unknown output extension. Plain text will be used.");
			return ProcessingSettings.OutputFormat.txt;
		}
	}

	/**
	 * Wait until task processing finishes and download result.
	 */
	private NliFormat waitAndDownloadResult(Task task, String outputPath) throws Exception {
		task = waitForCompletion(task);

		if (task.Status == Task.TaskStatus.Completed) {
			System.out.println("Downloading..");
			String downloadResult = restClient.downloadResult(task, outputPath);
			System.out.println("Ready");
			return xmlToJsonService.xmlToJsonConverter(downloadResult);
		} else if (task.Status == Task.TaskStatus.NotEnoughCredits) {
			System.out.println("Not enough credits to process document. "
					+ "Please add more pages to your application's account.");
			return null;
		} else {
			System.out.println("Task failed");
			return null;

		}
	}

	/**
	 * Wait until task processing finishes
	 */
	private Task waitForCompletion(Task task) throws Exception {
		// Note: it's recommended that your application waits
		// at least 2 seconds before making the first getTaskStatus request
		// and also between such requests for the same task.
		// Making requests more often will not improve your application performance.
		// Note: if your application queues several files and waits for them
		// it's recommended that you use listFinishedTasks instead (which is described
		// at https://ocrsdk.com/documentation/apireference/listFinishedTasks/).
		while (task.isTaskActive()) {

			Thread.sleep(5000);
			System.out.println("Waiting..");
			task = restClient.getTaskStatus(task.Id);
		}
		return task;
	}

}
