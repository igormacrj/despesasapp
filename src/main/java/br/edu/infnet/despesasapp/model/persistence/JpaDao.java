package br.edu.infnet.despesasapp.model.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

@Repository
public abstract class JpaDao<T> implements IDao<T>{

	@PersistenceContext
	private EntityManager em;
	
	private Class<T> classe;
	
	public Class getClasse() {
		return classe;
	}

	public JpaDao() {
		
	}
	
	public JpaDao(Class<T> classe) {
		super();
		this.classe = classe;
	}

	public void setClasse(Class classe) {
		this.classe = classe;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public List<T> getAll() {
		//String hql = "select t from " + classe.getName() + " t";
		//return em.createQuery(hql).getResultList();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(classe);
		query.from(classe);
		return em.createQuery(query).getResultList();
	}

	public void delete(Integer id) {
		T t = getOne(id);
		em.remove(t);
	}

	public T getOne(Integer id) {
		return (T) em.find(classe, id);
	}

	public void salvar(T t) {
		em.persist(t);
	}
	
	public void editar(T t) {
		em.merge(t);
	}
	





	
}
