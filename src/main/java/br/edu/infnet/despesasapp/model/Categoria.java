package br.edu.infnet.despesasapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	public Categoria () {
	}

	public Categoria(String nome, String tipo) {
		super();
		Nome = nome;
		Tipo = tipo;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nome;
	private String Tipo;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	
}
