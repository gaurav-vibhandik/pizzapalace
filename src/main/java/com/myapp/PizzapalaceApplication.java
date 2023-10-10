package com.myapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.myapp.repository")

public class PizzapalaceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzapalaceApplication.class, args);
		System.out.println("Pizza Palace Server up and running !!!");
	}

}
