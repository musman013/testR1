package com.nfinity.demo.petsdemotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PetsdemotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsdemotestApplication.class, args);
	}

}

