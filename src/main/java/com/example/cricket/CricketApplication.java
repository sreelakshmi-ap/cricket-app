package com.example.cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.cricket.fileupload.property.FileStorageProperties;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({
    FileStorageProperties.class
})

public class CricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketApplication.class, args);
	}

}
