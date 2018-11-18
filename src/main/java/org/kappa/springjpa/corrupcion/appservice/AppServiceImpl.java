package org.kappa.springjpa.corrupcion.appservice;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.kappa.springjpa.corrupcion.model.Corrupto;
import org.kappa.springjpa.corrupcion.model.CorruptoActivadeDTO;
import org.kappa.springjpa.corrupcion.repository.CorrupcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppServiceImpl implements AppService {
	
	@Autowired
	CorrupcionRepository corrupcionRepo;

	@Override
	public void engadir(Corrupto c) {
		corrupcionRepo.save(c);
	}

	@Override
	public List<Corrupto> todos() {
		return  (List<Corrupto>) corrupcionRepo.findAll();
	}

	@Override
	public Optional<Corrupto> encontrarId(Long id) {
		return corrupcionRepo.findById(id);
	}

	@Override
	public Long total() {
		return corrupcionRepo.count();
	}

	@Override
	public List<Corrupto> todosPorPartido() {
		
		return corrupcionRepo.todosPorPartido();
	}

	@Override
	public List<Corrupto> buscarAsunto(String asunto) {
		
		return corrupcionRepo.buscarAsunto(asunto);
	}

	@Override
	public void eliminar(Corrupto c) {
		corrupcionRepo.delete(c);
		
	}

	@Override
	public Object[] getAllCorruptosActividades() {
		
		return  corrupcionRepo.getAllCorruptosActividades();
	}

	@Override
	public List<Corrupto> qryTodosCorruptos() {
		
		return corrupcionRepo.qryTodosCorruptos();
	}

	@Override
	public List<Object[]> getAllListCorruptosActividades() {
		
		List<Object[]> l = corrupcionRepo.getAllListCorruptosActividades();
		return l;
	}	
}
