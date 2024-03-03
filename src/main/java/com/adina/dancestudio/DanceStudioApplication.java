package com.adina.dancestudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.sql.SQLOutput;

@SpringBootApplication
@ComponentScan(basePackages = "com.adina.dancestudio")
public class DanceStudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanceStudioApplication.class, args);
	}

}
