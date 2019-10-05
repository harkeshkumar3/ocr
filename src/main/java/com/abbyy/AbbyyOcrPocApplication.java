package com.abbyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.abbyy.file.upload.service.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class AbbyyOcrPocApplication {


	public static void main(String[] args) {
		SpringApplication.run(AbbyyOcrPocApplication.class, args);
	}


}
