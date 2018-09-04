package org.kappa.springjpa.corrupcion.repository;

import java.util.List;

import org.kappa.springjpa.corrupcion.model.Corrupto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CorrupcionRepository extends CrudRepository<Corrupto, Long> {
	
	public List<Corrupto> todosPorPartido();
	public List<Corrupto> buscarAsunto(@Param("asunto") String asunto);
}
