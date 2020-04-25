package br.com.fiap.dao.Impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CadastroInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K> {
	
	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	@Override
	public void remover(K id) throws CadastroInexistenteException {
		T entidade = consultar(id);
		if(entidade == null)
			throw new CadastroInexistenteException();
		em.remove(entidade);
	}
	
	@Override
	public T consultar(K id) {
		return em.find(clazz, id);
	}
	
	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}
	
	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
}
