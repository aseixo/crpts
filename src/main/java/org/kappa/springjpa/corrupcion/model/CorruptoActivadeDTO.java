package org.kappa.springjpa.corrupcion.model;

import java.util.Date;

public class CorruptoActivadeDTO {
	
	private String nome;
	private String partido;
	private String descricion;
	private Date dataControl;
	
	public CorruptoActivadeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CorruptoActivadeDTO(String nome, String partido, String descricion, Date dataControl) {
		super();
		this.nome = nome;
		this.partido = partido;
		this.descricion = descricion;
		this.dataControl = dataControl;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getDescricion() {
		return descricion;
	}

	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}

	public Date getDataControl() {
		return dataControl;
	}

	public void setDataControl(Date dataControl) {
		this.dataControl = dataControl;
	}

	@Override
	public String toString() {
		return "CorruptoActivadeDTO [nome=" + nome + ", partido=" + partido + ", descricion=" + descricion
				+ ", dataControl=" + dataControl + "]";
	}
	
	

}
