package com.tasks.jsontasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class JsontasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsontasksApplication.class, args);
	}

}
