package org.kappa.springjpa.corrupcion.appcontroller;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.kappa.springjpa.corrupcion.CorrupcionApplication;
import org.kappa.springjpa.corrupcion.appservice.AppService;
import org.kappa.springjpa.corrupcion.model.Corrupto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {
	
	private static Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	AppService appService;
	
	@GetMapping("/")
	public String index() {
		return "Aplicativo " + CorrupcionApplication.class.getName() + " iniciado";
	}
	
	@GetMapping("/todos")
	public List<Corrupto> verTodos() {
		//return appService.todos();
		return appService.qryTodosCorruptos();
	}
	
	@GetMapping("/partidos")
	public List<Corrupto> verPorPartidos() {
		return appService.todosPorPartido();
	}
	
	@GetMapping("/actividade")
	public Object[] verPorCorruptosPorActividade() {
		return appService.getAllCorruptosActividades();
	}
	
	@GetMapping("/listaactividade")
	public List<Object[]> verListaPorCorruptosPorActividade() {
		
		List<Object[]> l = appService.getAllListCorruptosActividades();
		for (Object[] obj: l) {
			logger.info((obj[0].toString() + " " + obj[1].toString() + " " + obj[2].toString() + " " + obj[3].toString() ));
		}
		return appService.getAllListCorruptosActividades();
	}
	
	@GetMapping("/asunto/{asunto}")
	public List<Corrupto> buscarAsunto(@PathVariable("asunto")  String asunto) {
		return appService.buscarAsunto(asunto);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	public String novoCorrupto(@RequestBody Corrupto c) {
		Long antes = appService.total();
		appService.engadir(c);
		Long engadidos = antes - appService.total();
		return c.toString() + " Corruptos engadidos: " + engadidos.toString();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Corrupto> buscarId(@PathVariable("id") Long id) {
		return appService.encontrarId(id);
	}
	
	@GetMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		Corrupto c = new Corrupto();
		c.setCorruptoId(id);
		appService.eliminar(c);
	}
	
	

}
