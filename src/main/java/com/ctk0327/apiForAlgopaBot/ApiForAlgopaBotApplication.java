package com.ctk0327.apiForAlgopaBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ctk0327")
public class ApiForAlgopaBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiForAlgopaBotApplication.class, args);
	}
}
