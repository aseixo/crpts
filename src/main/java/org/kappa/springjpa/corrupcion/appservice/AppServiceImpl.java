package org.kappa.springjpa.corrupcion.appservice;

import java.util.List;
import java.util.Optional;

import org.kappa.springjpa.corrupcion.model.Corrupto;
import org.kappa.springjpa.corrupcion.repository.CorrupcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppServiceImpl implements AppService {
	
	@Autowired
	CorrupcionRepository corrupcionRepository;

	@Override
	public void engadir(Corrupto c) {
		corrupcionRepository.save(c);
	}

	@Override
	public List<Corrupto> todos() {
		return  (List<Corrupto>) corrupcionRepository.findAll();
	}

	@Override
	public Optional<Corrupto> encontrarId(Long id) {
		return corrupcionRepository.findById(id);
	}

	@Override
	public Long total() {
		return corrupcionRepository.count();
	}

	@Override
	public List<Corrupto> todosPorPartido() {
		
		return corrupcionRepository.todosPorPartido();
	}

	@Override
	public List<Corrupto> buscarAsunto(String asunto) {
		
		return corrupcionRepository.buscarAsunto(asunto);
	}

	@Override
	public void eliminar(Corrupto c) {
		corrupcionRepository.delete(c);
		
	}

	@Override
	public Object[] getAllCorruptosActividades() {
		
		return  corrupcionRepository.getAllCorruptosActividades();
	}

	@Override
	public List<Corrupto> qryTodosCorruptos() {
		
		return corrupcionRepository.qryTodosCorruptos();
	}

	@Override
	public List<Object[]> getAllListCorruptosActividades() {

		return corrupcionRepository.getAllListCorruptosActividades();
	}

	@Override
	public Integer getlastCorruptoId(Integer lastId) {
		
		return corrupcionRepository.getlastCorruptoId(lastId);
	}	
	
	public Optional<List<Corrupto>> buscarNome(){
		
		return corrupcionRepository.buscarNome();
	}



}
