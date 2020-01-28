package com.mindgate.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mindgate")
@SpringBootApplication
public class TravelMain {
	public static void main(String[] args) {
		System.out.println("g4 !!! --->sever start<---");
		ApplicationContext ctx11 = SpringApplication.run(TravelMain.class, args);
		System.out.println("hai g4 !!! --->sever stop<---");

	}

}
