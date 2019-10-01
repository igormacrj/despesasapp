package br.edu.infnet.despesasapp.model.persistence;

import org.springframework.stereotype.Repository;

import br.edu.infnet.despesasapp.model.Movimentacao;

@Repository
public class MovimentacaoDao extends JpaDao<Movimentacao> {

	public MovimentacaoDao() {
		super(Movimentacao.class);
	}
}
