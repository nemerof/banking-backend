package com.usb.UniversalSavingsBank;

import com.usb.UniversalSavingsBank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UniversalSavingsBankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversalSavingsBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(); // RESERVED FOR TEST PURPOSES
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"UniversalBank API",
				"",
				"1.0",
				"",
				"Denys Volkov",
				"Ostrobramska ©",
				""
		);
	}
}
