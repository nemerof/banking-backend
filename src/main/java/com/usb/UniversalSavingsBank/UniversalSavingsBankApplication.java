package com.usb.UniversalSavingsBank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversalSavingsBankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversalSavingsBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(); // RESERVED FOR TEST PURPOSES
	}
}
