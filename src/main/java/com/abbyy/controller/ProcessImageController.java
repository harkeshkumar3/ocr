package com.abbyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abbyy.file.upload.service.FileStorageService;
import com.abbyy.formatter.NliFormat;
import com.abbyy.formatter.ProcessImageRequestParam;
import com.abbyy.google.api.GoogleJsonExtractorService;
import com.abbyy.service.AbbyyOcrService;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;

@RestController
public class ProcessImageController {

	@Autowired
	private AbbyyOcrService AbbyyOcrService;

	@Autowired
	private ResourceLoader resourceLoader;
	@Autowired
	private CloudVisionTemplate cloudVisionTemplate;
	
	@Autowired
    private FileStorageService fileStorageService;

	@PostMapping(path = "/processImage")
	public NliFormat processImage(@RequestBody ProcessImageRequestParam filePath) {

		String[] args = new String[3];
		// { "recognize", "/home/harkesh/Desktop/12.png", "/home/harkesh/Desktop/rs.xml"
		// };

		args[0] = "recognize";
		args[1] = filePath.getFilePath();
		args[2] = "rs.xml";
		System.out.println(args[1]);
		return AbbyyOcrService.AbbyyOcrProcessor(args);
	}

	@PostMapping(path = "/getTextDetection")
	public NliFormat getTextDetection(@RequestBody ProcessImageRequestParam filePath) {
		Resource imageResource = this.resourceLoader.getResource("file:"+filePath.getFilePath());
		AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
				Feature.Type.DOCUMENT_TEXT_DETECTION);
	//	List<EntityAnnotation> textAnnotationsList = response.getTextAnnotationsList();
		
		
		return GoogleJsonExtractorService.getGoogleJsonExtract(response.getTextAnnotationsList());
	}
	
	  @PostMapping("/uploadFile")
	    public NliFormat uploadFile(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);
	        
	        System.out.println("Uplaoded file name "+ fileName);

	        Resource imageResource = this.resourceLoader.getResource("file:/home/harkesh/Documents/"+fileName);
			AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
					Feature.Type.DOCUMENT_TEXT_DETECTION);
		//	List<EntityAnnotation> textAnnotationsList = response.getTextAnnotationsList();
			
			
			return GoogleJsonExtractorService.getGoogleJsonExtract(response.getTextAnnotationsList());
			
			//return imageResource;
	    }

}
