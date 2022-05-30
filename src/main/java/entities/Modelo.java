package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Modelo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmodelo;
	@Column(nullable=false)
	private String descricao;
	@Column(nullable=false)
	private Integer potencia;
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marca;

@OneToMany(mappedBy= "modelo")
	
	private List<Automovel> automoveis = new ArrayList();
	

	
	public Modelo() {
}

	public Modelo(Integer idmodelo, String descricao, Integer potencia, Marca marca) {
	this.idmodelo = idmodelo;
	this.descricao = descricao;
	this.potencia = potencia;
	this.marca = marca;
}

	
	public Integer getIdmodelo() {
		return idmodelo;
	}

	public void setIdmodelo(Integer idmodelo) {
		this.idmodelo = idmodelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Marca getMarca() {
		return marca;
	}
	

	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	
	public void setMarca(Marca mm) {
		this.marca=mm;
	}
	
	public void addAutomovel(Automovel a) {
		if(a!= null) {
			this.automoveis.add(a);
			a.setModelo(this);
		}
	}
	
public void removeAutomovel(Automovel a) {
	if(this.automoveis.contains(a)) {
		this.removeAutomovel(a);
		a.setModelo(null);
}
	
	
	
	
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + ((idmodelo == null) ? 0 : idmodelo.hashCode());
	result = prime * result + ((marca == null) ? 0 : marca.hashCode());
	result = prime * result + ((potencia == null) ? 0 : potencia.hashCode());
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
	Modelo other = (Modelo) obj;
	if (descricao == null) {
		if (other.descricao != null)
			return false;
	} else if (!descricao.equals(other.descricao))
		return false;
	if (idmodelo == null) {
		if (other.idmodelo != null)
			return false;
	} else if (!idmodelo.equals(other.idmodelo))
		return false;
	if (marca == null) {
		if (other.marca != null)
			return false;
	} else if (!marca.equals(other.marca))
		return false;
	if (potencia == null) {
		if (other.potencia != null)
			return false;
	} else if (!potencia.equals(other.potencia))
		return false;
	return true;
}

@Override
public String toString() {
	return "Modelo [idmodelo=" + idmodelo + ", descricao=" + descricao + ", potencia=" + potencia + ", marca=" + marca
			+ "]";
}


}
