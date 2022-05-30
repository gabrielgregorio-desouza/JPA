package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marca implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmarca;
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy= "marca")
	private List<Modelo> modelos = new ArrayList();

	public Marca(Integer idmarca, String nome) {
		this.idmarca = idmarca;
		this.nome = nome;
	}

	public Marca() {
	}

	public Integer getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void addModelo(Modelo m) {
		if(m!= null) {
			this.modelos.add(m);
			m.setMarca(this);
		}
	}
	
	public void removeModelo(Modelo m) {
		if(this.modelos.contains(m)) {
			this.removeModelo(m);
			m.setMarca(null);
	}
	
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idmarca == null) ? 0 : idmarca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Marca other = (Marca) obj;
		if (idmarca == null) {
			if (other.idmarca != null)
				return false;
		} else if (!idmarca.equals(other.idmarca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Marca [idmarca=" + idmarca + ", nome=" + nome + "]";
	}
	
	
	
}
