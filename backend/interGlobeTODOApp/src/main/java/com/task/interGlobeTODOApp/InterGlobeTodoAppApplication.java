package com.task.interGlobeTODOApp;

import com.task.interGlobeTODOApp.controllers.ToDoTaskController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ToDoTaskController.class)
public class InterGlobeTodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterGlobeTodoAppApplication.class, args);
	}
}
