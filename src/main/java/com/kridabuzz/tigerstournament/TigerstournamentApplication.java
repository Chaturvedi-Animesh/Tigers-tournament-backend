package com.kridabuzz.tigerstournament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TigerstournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TigerstournamentApplication.class, args);
		System.out.println("Spring Boot Application Up and Running in port 8082");
	}

}
