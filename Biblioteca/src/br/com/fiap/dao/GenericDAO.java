package br.com.fiap.dao;

import br.com.fiap.exception.CadastroInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T,K> {
	
	void cadastrar(T entidade);
	
	void remover(K id) throws CadastroInexistenteException;
	
	T consultar(K id);
	
	void atualizar(T entidade);
	
	void commit() throws CommitException;
	
}
