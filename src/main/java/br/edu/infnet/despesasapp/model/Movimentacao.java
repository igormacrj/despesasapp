package br.edu.infnet.despesasapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@ManyToOne
	@JoinColumn(name="CategoriaId")
	private Categoria categoria;
	private Integer idCategoria;
	private Timestamp dataHora;	
	
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Timestamp getDataHora() {
		return dataHora;
	}
	
	public String getDataHoraString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(dataHora);
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	private Float valor;
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Movimentacao(){
	}

	public Movimentacao(Integer idCategoria, Timestamp dataHora, Float valor) {
		super();
		this.idCategoria = idCategoria;
		this.dataHora = dataHora;
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


}
