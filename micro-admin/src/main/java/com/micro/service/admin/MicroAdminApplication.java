package com.micro.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.micro.service.biz")
public class MicroAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAdminApplication.class, args);
	}
}
