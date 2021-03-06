package org.kappa.springjpa.corrupcion.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.kappa.springjpa.corrupcion.model.Corrupto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CorrupcionRepository extends CrudRepository<Corrupto, Long> {
	
	public List<Corrupto> todosPorPartido();
	public List<Corrupto> buscarAsunto(@Param("asunto") String asunto);
	
	@Transactional
	@Query(value = "{call getAllByName}", nativeQuery= true)
	public Object[] getAllCorruptosActividades();
	
	@Query(value = "{call qryTodosCorruptos}", nativeQuery= true)
	public List<Corrupto> qryTodosCorruptos();
	
	@Query(value = "{call getAllByName}", nativeQuery= true)
	public List<Object[]> getAllListCorruptosActividades();
	
	@Query(value = "{call last_corrupto_id}", nativeQuery= true)
	public Integer getlast_corrupto_id(@Param("last_id") Integer last_id);
}
