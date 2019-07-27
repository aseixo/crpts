package org.kappa.springjpa.corrupcion;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages= {
			"org.kappa.springjpa.corrupcion.appcontroller", 
			"org.kappa.springjpa.corrupcion.appservice"
			})
@EnableJpaRepositories("org.kappa.springjpa.corrupcion.repository")
@EntityScan("org.kappa.springjpa.corrupcion.model")
public class AppConfig {

}
