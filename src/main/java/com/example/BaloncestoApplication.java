package com.example;

import com.example.service.BaloncestoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = { BaloncestoApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
public class BaloncestoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(BaloncestoApplication.class, args);

		BaloncestoService BaloncestoService=context.getBean(BaloncestoService.class);

		BaloncestoService.testBaloncesto();

	}
}
