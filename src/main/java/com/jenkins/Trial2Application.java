package com.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Trial2Application {

	public static void main(String[] args) {
		SpringApplication.run(Trial2Application.class, args);
	}

}
