package br.edu.infnet.despesasapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.despesasapp.model.Movimentacao;
import br.edu.infnet.despesasapp.model.persistence.MovimentacaoDao;

@Service
public class MovimentacaoService {
 
@Autowired
   private MovimentacaoDao dao;
	
	public MovimentacaoDao getDao() {
	return dao;
}

public void setDao(MovimentacaoDao dao) {
	this.dao = dao;
}

	public MovimentacaoService() {
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public List<Movimentacao> getMovimentacoes() {
		return dao.getAll();
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public List<Movimentacao> getMovimentacoesReceita() {
		List<Movimentacao> movimentacao = dao.getAll();
		List<Movimentacao> movimentacaoReceita = new ArrayList<Movimentacao>(); 
		for (Movimentacao mov: movimentacao) {
			if (mov.getCategoria().getTipo().equals("Receita")) {
				movimentacaoReceita.add(mov);
			}	
		}	
		return movimentacaoReceita;
		//return dao.getAll();
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public List<Movimentacao> getMovimentacoesDespesa() {
		List<Movimentacao> movimentacao = dao.getAll();
		List<Movimentacao> movimentacaoDespesa = new ArrayList<Movimentacao>(); 
		for (Movimentacao mov: movimentacao) {
			if (mov.getCategoria().getTipo().equals("Despesa")) {
				movimentacaoDespesa.add(mov);
			}	
		}	
		return movimentacaoDespesa;
		//return dao.getAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void persite(Movimentacao movimentacao) {
		dao.salvar(movimentacao);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Movimentacao movimentacao) {
		dao.editar(movimentacao);
	}

	@Transactional(propagation = Propagation.NEVER)
	public Movimentacao getMovimentacao(String id) {
		Objects.requireNonNull(id, "vai pra lá com esse nulo");
		return dao.getOne(Integer.valueOf(id));
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) {
		dao.delete(id);
	}

}
