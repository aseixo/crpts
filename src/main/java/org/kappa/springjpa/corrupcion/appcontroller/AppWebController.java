package org.kappa.springjpa.corrupcion.appcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppWebController {
	
	//@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("mensaxe", "Proba Spring Boot + Ajax");
		return "index";
	}
}
