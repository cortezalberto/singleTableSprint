package com.example.sigleTable;

import com.example.sigleTable.entidades.Profesor;
import com.example.sigleTable.enuneraciones.Titulos;
import com.example.sigleTable.repositorios.AlumnoRepository;
import com.example.sigleTable.repositorios.PersonaRepository;
import com.example.sigleTable.repositorios.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SigleTableApplication {


	private static final Logger logger = LoggerFactory.getLogger(SigleTableApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;
	public static void main(String[] args) {
		SpringApplication.run(SigleTableApplication.class, args);

		System.out.println("funcionando");
	}




	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			// Creo un objeto alumno
			Profesor pro1 = Profesor.builder()
					.nombre("Alberto")
					.nombre("Cortez")
					.fechaIngreso(LocalDate.of(2022, 1, 1))
					.cantHijos(2)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("123.45"))
					.build();

			// Lo grabo a través del repositorio de Spring
			profesorRepository.save(pro1);











		};

	};




}
