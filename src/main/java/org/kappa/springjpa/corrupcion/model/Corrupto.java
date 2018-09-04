package org.kappa.springjpa.corrupcion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="corruptos")
@NamedQueries({@NamedQuery(name="Corrupto.todosPorPartido", query="select c from Corrupto c where c.partido <>'*' order by c.partido, c.nome asc"),
				@NamedQuery(name="Corrupto.buscarAsunto", query="select c from Corrupto c where c.asunto like concat('%', :asunto,'%') ")})
public class Corrupto implements Serializable{

	
	private static final long serialVersionUID = -7521709863717195763L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="corrupto_id")
	private Long corruptoId;
	@Column(name="nome")
	private String nome;
	@Column(name="partido")
	private String partido;
	@Column(name="asunto")
	private String asunto;
	@Column(name="condena")
	private int condena;
	
	public Corrupto() {
	}
	
	public Corrupto(Long corruptoId, String nome, String partido, String asunto, int condena) {
		super();
		this.corruptoId = corruptoId;
		this.nome = nome;
		this.partido = partido;
		this.asunto = asunto;
		this.condena = condena;
	}
	
	public Corrupto(String nome, String partido, String asunto, int condena) {
		super();
		this.nome = nome;
		this.partido = partido;
		this.asunto = asunto;
		this.condena = condena;
	}
	
	public Long getCorruptoId() {
		return corruptoId;
	}
	public void setCorruptoId(Long corruptoId) {
		this.corruptoId = corruptoId;
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
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public int getCondena() {
		return condena;
	}
	public void setCondena(int condena) {
		this.condena = condena;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asunto == null) ? 0 : asunto.hashCode());
		result = prime * result + condena;
		result = prime * result + ((corruptoId == null) ? 0 : corruptoId.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((partido == null) ? 0 : partido.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corrupto other = (Corrupto) obj;
		if (asunto == null) {
			if (other.asunto != null)
				return false;
		} else if (!asunto.equals(other.asunto))
			return false;
		if (condena != other.condena)
			return false;
		if (corruptoId == null) {
			if (other.corruptoId != null)
				return false;
		} else if (!corruptoId.equals(other.corruptoId))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (partido == null) {
			if (other.partido != null)
				return false;
		} else if (!partido.equals(other.partido))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Corrupto [corruptoId=" + corruptoId + ", nome=" + nome + ", partido=" + partido + ", asunto=" + asunto
				+ ", condena=" + condena + "]";
	}

	
}
