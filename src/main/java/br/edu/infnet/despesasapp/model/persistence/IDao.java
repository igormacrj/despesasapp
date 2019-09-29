package br.edu.infnet.despesasapp.model.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public interface IDao<T> {
	
	void salvar(T t);
	
	void editar(T t);
	
	void delete(Integer id);
	
	T getOne(Integer id);
	
	List<T> getAll();
	
	EntityManager getEm();

	void setEm(EntityManager em);
}
