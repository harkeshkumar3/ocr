package com.abbyy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbyy.formatter.NliFormat;
import com.abbyy.formatter.ProcessImageRequestParam;
import com.abbyy.google.api.GoogleBlock;
import com.abbyy.google.api.GoogleJsonExtractorService;
import com.abbyy.google.api.GooglefilterSet;
import com.abbyy.service.AbbyyOcrService;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;

@RestController
public class ProcessImageController {

	@Autowired
	private AbbyyOcrService AbbyyOcrService;

	@Autowired
	private ResourceLoader resourceLoader;
	@Autowired
	private CloudVisionTemplate cloudVisionTemplate;

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

	@GetMapping(path = "/getTextDetection")
	public NliFormat getTextDetection() {
		Resource imageResource = this.resourceLoader.getResource("file:/home/harkesh/Desktop/12.png");
		AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
				Feature.Type.DOCUMENT_TEXT_DETECTION);
	//	List<EntityAnnotation> textAnnotationsList = response.getTextAnnotationsList();
		
		
		return GoogleJsonExtractorService.getGoogleJsonExtract(response.getTextAnnotationsList());
	}

}
