package org.kappa.springjpa.corrupcion.appservice;

import java.util.List;
import java.util.Optional;

import org.kappa.springjpa.corrupcion.model.Corrupto;
import org.kappa.springjpa.corrupcion.repository.CorrupcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

}
