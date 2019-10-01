package br.edu.infnet.despesasapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@ManyToOne
	@JoinColumn(name="categoriaId")
	private Categoria categoria;	
	//private LocalDate data;	
	private Float valor;
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Movimentacao(){
	}

	public Movimentacao(Categoria categoria, /*LocalDate data*/ Float valor) {
		super();
		this.categoria = categoria;
//		this.data = data;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

//	public LocalDate getData() {
//		return data;
//	}
//
//	public void setData(LocalDate data) {
//		this.data = data;
//	}
}
