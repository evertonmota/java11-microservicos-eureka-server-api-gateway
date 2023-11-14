package com.devsuperior.msworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPayrollApplication.class, args);
	}

}
