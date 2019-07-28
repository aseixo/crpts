package org.kappa.springjpa.corrupcion.appcontroller;

import java.util.List;
import java.util.Optional;

import org.kappa.springjpa.corrupcion.appservice.AppService;
import org.kappa.springjpa.corrupcion.model.Corrupto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/todos")
	public List<Corrupto> verTodos() {
		// return appService.todos();
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

	@GetMapping("/lastid")
	public String getLastId() {
		return appService.getlastCorruptoId(1).toString();
	}

	@GetMapping("/listaactividade")
	public List<Object[]> verListaPorCorruptosPorActividade() {

		List<Object[]> l = appService.getAllListCorruptosActividades();
		for (Object[] obj : l) {
			logger.info("{} {} {} {}", obj[0], obj[1], obj[2], obj[3]);
		}
		return appService.getAllListCorruptosActividades();
	}

	@GetMapping("/asunto/{asunto}")
	public List<Corrupto> buscarAsunto(@PathVariable("asunto") String asunto) {
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

	@GetMapping("/proba")
	public ResponseEntity<Optional<List<Corrupto>>> buscarNome() {

		logger.info("consulta de todos os corruptos na bd");
		Optional<List<Corrupto>> resNome = appService.buscarNome();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<Optional<List<Corrupto>>> entity = new ResponseEntity<>(resNome, responseHeaders, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/join")
	public ResponseEntity<Optional<List<Object>>> joinActividade() {

		logger.info("consulta join corruptos actividade");
		Optional<List<Object>> resNome = appService.joinActividade();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("CorruptosJoinActividade", "consultajoin");
		ResponseEntity<Optional<List<Object>>> entity = new ResponseEntity<>(resNome, responseHeaders, HttpStatus.OK);
		return entity;
	}

}
