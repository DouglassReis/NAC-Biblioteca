package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.Impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Forma;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Idioma;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Locacao;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.entity.Status;
import br.com.fiap.entity.TipoLocacao;
import br.com.fiap.exception.CommitException;



public class ConsoleView {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		Locacao locacao = new Locacao(Calendar.getInstance(), Calendar.getInstance() , 50.0f, TipoLocacao.SEMANAL, 2);
		
		List<Livro> livros = new ArrayList<Livro>();
		
		Editora e1 = new Editora("Martin Claret", "123456734-12", "1234-1234");
		
		Editora e2 = new Editora("Harper Collins", "564456734-12", "2344-6534");
		
		livros.add(new Livro("A Origem das Especies", Genero.LITERATURA_CIENTIFICA, "Charles Darwin", Idioma.PORTUGUES, e1));
		
		livros.add(new Livro("O Hobbit", Genero.FANTASIA, "J.R.R Tolkien", Idioma.PORTUGUES, e2));
		
		locacao.setLivros(livros);
		
		locacao.setPagamento(new Pagamento(Status.PENDENTE, Forma.CREDITO, 50.0f));
		
		Cliente cliente = new Cliente("Thiago", "234.345.345-56", "98345-9432");
		
		cliente.adcLocacao(locacao);
		
		dao.cadastrar(cliente);
		try {
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		em.close();
		fabrica.close();
	}
}
