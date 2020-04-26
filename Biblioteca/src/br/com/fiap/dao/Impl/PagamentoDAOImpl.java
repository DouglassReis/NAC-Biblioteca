package br.com.fiap.dao.Impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO{

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
	}
}
