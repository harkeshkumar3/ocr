package com.abbyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbyy.formatter.NliFormat;
import com.abbyy.formatter.ProcessImageRequestParam;
import com.abbyy.service.AbbyyOcrService;

@RestController
public class ProcessImageController {
	
	@Autowired
	private AbbyyOcrService AbbyyOcrService;

	@PostMapping(path= "/processImage")
	public NliFormat processImage(@RequestBody ProcessImageRequestParam filePath) {
		
		String[] args = new String[3];
		//{ "recognize", "/home/harkesh/Desktop/12.png", "/home/harkesh/Desktop/rs.xml" };

		args[0]="recognize";
		args[1]=filePath.getFilePath();
		args[2]= "rs.xml";
		System.out.println(args[1]);
		return AbbyyOcrService.AbbyyOcrProcessor(args);
	}

}
