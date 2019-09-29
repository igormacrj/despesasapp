package br.edu.infnet.despesasapp.model.persistence;

import org.springframework.stereotype.Repository;

import br.edu.infnet.despesasapp.model.Categoria;

@Repository
public class CategoriaDao extends JpaDao<Categoria> {

	public CategoriaDao() {
		super(Categoria.class);
	}
}
