package com.example.EmployesAPICRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EmployesApicrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployesApicrudApplication.class, args);
		System.out.println("chl ria");

	}
}
