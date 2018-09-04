package org.kappa.springjpa.corrupcion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {
			"org.kappa.springjpa.corrupcion.appcontroller", 
			"org.kappa.springjpa.corrupcion.appservice", 
			"org.kappa.springjpa.corrupcion.repository"
			})
public class AppConfig {

}
