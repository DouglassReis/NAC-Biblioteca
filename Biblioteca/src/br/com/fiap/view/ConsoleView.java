package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.Impl.ClienteDAOImpl;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Locacao;
import br.com.fiap.entity.TipoLocacao;


public class ConsoleView {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		Locacao locacao = new Locacao(Calendar.getInstance(), Calendar.getInstance() , 50.0f, TipoLocacao.SEMANAL, 2);
		
		List<Livro> livros = new ArrayList();
		
		livros.add(new Livro());
	}
}
