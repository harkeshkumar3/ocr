package com.abbyy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abbyy.service.AbbyyOcrService;

@SpringBootApplication
public class AbbyyOcrPocApplication implements CommandLineRunner {

	@Autowired
	AbbyyOcrService service;

	public static void main(String[] args) {
		SpringApplication.run(AbbyyOcrPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	//	service.AbbyyOcrProcessor();
	}

}
