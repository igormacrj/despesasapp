package br.edu.infnet.despesasapp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.despesasapp.model.Categoria;
import br.edu.infnet.despesasapp.model.persistence.CategoriaDao;

@Service
public class CategoriaService {
 
@Autowired
   private CategoriaDao dao;
	
	public CategoriaDao getDao() {
	return dao;
}

public void setDao(CategoriaDao dao) {
	this.dao = dao;
}

	public CategoriaService() {
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public List<Categoria> getCategorias() {
		return dao.getAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void persite(Categoria categoria) {
		dao.salvar(categoria);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Categoria categoria) {
		dao.editar(categoria);
	}

	@Transactional(propagation = Propagation.NEVER)
	public Categoria getCategoria(String id) {
		Objects.requireNonNull(id, "vai pra lá com esse nulo");
		return dao.getOne(Integer.valueOf(id));
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) {
		dao.delete(id);
	}

}
