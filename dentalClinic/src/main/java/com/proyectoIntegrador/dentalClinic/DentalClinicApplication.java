package com.proyectoIntegrador.dentalClinic;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;


import java.sql.SQLException;

@SpringBootApplication
public class DentalClinicApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(DentalClinicApplication.class);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(DentalClinicApplication.class, args);

		LOGGER.info("Dental Clinic is now running...");
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}



	@GetMapping("hola")
	public String saludar(){
		String saludo = "Hola Camada 4";
		LOGGER.info(saludo);
		return saludo;
	}



}

