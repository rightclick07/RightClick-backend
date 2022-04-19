package com.rightclick.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class RightclickBackendApplication {

	public static void main(String[] args) {
		System.out.println("Welcome");
		SpringApplication.run(RightclickBackendApplication.class, args);
	}

}
