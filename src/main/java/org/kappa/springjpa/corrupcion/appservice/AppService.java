package org.kappa.springjpa.corrupcion.appservice;

import java.util.List;
import java.util.Optional;

import org.kappa.springjpa.corrupcion.model.Corrupto;

public interface AppService {
	
	public void engadir(Corrupto c);
	public List<Corrupto> todos();
	
	//Mediante Optional evitamos o erro con valores nulos na consulta, i.e., vacía
	public Optional<Corrupto> encontrarId(Long id);
	public Long total();
	public List<Corrupto> todosPorPartido();
	public List<Corrupto> buscarAsunto(String asunto);
	public void eliminar(Corrupto c);

}
