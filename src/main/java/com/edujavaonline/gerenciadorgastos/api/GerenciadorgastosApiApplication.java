package com.edujavaonline.gerenciadorgastos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GerenciadorgastosApiApplication.class)
public class GerenciadorgastosApiApplication {	

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorgastosApiApplication.class, args);
	}

}
