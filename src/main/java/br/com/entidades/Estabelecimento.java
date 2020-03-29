package br.com.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cnpj;
	private String rua;
	private Long numeroResidencia;
	private String telefone;
	private Long qtdVagaMoto;
	private Long qtdVagaCarro;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(Long numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getQtdVagaMoto() {
		return qtdVagaMoto;
	}

	public void setQtdVagaMoto(Long qtdVagaMoto) {
		this.qtdVagaMoto = qtdVagaMoto;
	}

	public Long getQtdVagaCarro() {
		return qtdVagaCarro;
	}

	public void setQtdVagaCarro(Long qtdVagaCarro) {
		this.qtdVagaCarro = qtdVagaCarro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Estabelecimento other = (Estabelecimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
