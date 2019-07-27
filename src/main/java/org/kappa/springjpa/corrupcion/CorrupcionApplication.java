package org.kappa.springjpa.corrupcion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages= {
			"org.kappa.springjpa.corrupcion.appcontroller", 
			"org.kappa.springjpa.corrupcion.appservice"
			})
@EnableJpaRepositories("org.kappa.springjpa.corrupcion.repository")
@EntityScan("org.kappa.springjpa.corrupcion.model")
public class CorrupcionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrupcionApplication.class, args);
	}
}
