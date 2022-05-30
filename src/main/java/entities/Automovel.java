package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Automovel implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idautomovel;
	@Column(nullable=false)
	private Integer anofabricacao;
	@Column(nullable=false)
	private Integer anomodelo;
	@Column(nullable=false)
	private String observacoes;
	@Column(nullable=false)
	private float preco;
	@Column(nullable=false)
	private Integer kilometragem;
	
	@OneToOne
	@JoinColumn(name="idmodelo")
	private Modelo modelo;
	
	
	
	
	
	

public Automovel(Integer idautomovel, Integer anofabricacao, Integer anomodelo, String observacoes, float preco,
			Integer kilometragem, Modelo modelo) {
		super();
		this.idautomovel = idautomovel;
		this.anofabricacao = anofabricacao;
		this.anomodelo = anomodelo;
		this.observacoes = observacoes;
		this.preco = preco;
		this.kilometragem = kilometragem;
		this.modelo = modelo;
	}


public Automovel() {
	}

	public Integer getIdautomovel() {
	return idautomovel;
}



public void setIdautomovel(Integer idautomovel) {
	this.idautomovel = idautomovel;
}



public Integer getAnofabricacao() {
	return anofabricacao;
}



public void setAnofabricacao(Integer anofabricacao) {
	this.anofabricacao = anofabricacao;
}



public Integer getAnomodelo() {
	return anomodelo;
}



public void setAnomodelo(Integer anomodelo) {
	this.anomodelo = anomodelo;
}



public String getObservacoes() {
	return observacoes;
}



public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
}



public float getPreco() {
	return preco;
}



public void setPreco(float preco) {
	this.preco = preco;
}



public Integer getKilometragem() {
	return kilometragem;
}



public void setKilometragem(Integer kilometragem) {
	this.kilometragem = kilometragem;
}



public Modelo getModelo() {
	return modelo;
}



	public void setModelo(Modelo m) {
		this.modelo=m;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anofabricacao == null) ? 0 : anofabricacao.hashCode());
		result = prime * result + ((anomodelo == null) ? 0 : anomodelo.hashCode());
		result = prime * result + ((idautomovel == null) ? 0 : idautomovel.hashCode());
		result = prime * result + ((kilometragem == null) ? 0 : kilometragem.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + Float.floatToIntBits(preco);
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
		Automovel other = (Automovel) obj;
		if (anofabricacao == null) {
			if (other.anofabricacao != null)
				return false;
		} else if (!anofabricacao.equals(other.anofabricacao))
			return false;
		if (anomodelo == null) {
			if (other.anomodelo != null)
				return false;
		} else if (!anomodelo.equals(other.anomodelo))
			return false;
		if (idautomovel == null) {
			if (other.idautomovel != null)
				return false;
		} else if (!idautomovel.equals(other.idautomovel))
			return false;
		if (kilometragem == null) {
			if (other.kilometragem != null)
				return false;
		} else if (!kilometragem.equals(other.kilometragem))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Automovel [idautomovel=" + idautomovel + ", anofabricacao=" + anofabricacao + ", anomodelo=" + anomodelo
				+ ", observacoes=" + observacoes + ", preco=" + preco + ", kilometragem=" + kilometragem + "]";
	}
	
	
	
}
