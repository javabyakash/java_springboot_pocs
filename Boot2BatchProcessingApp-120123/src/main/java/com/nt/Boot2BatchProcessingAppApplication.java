package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nt")
public class Boot2BatchProcessingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot2BatchProcessingAppApplication.class, args);
	}

}
