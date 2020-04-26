package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.Impl.ClienteDAOImpl;
import br.com.fiap.dao.Impl.EditoraDAOImpl;
import br.com.fiap.dao.Impl.LivroDAOImpl;
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
		
		ClienteDAO Cdao = new ClienteDAOImpl(em);
		LivroDAO Ldao = new LivroDAOImpl(em);
		EditoraDAO Edao = new EditoraDAOImpl(em);
		
		Locacao locacao = new Locacao(Calendar.getInstance(), new GregorianCalendar(2020, Calendar.APRIL, 02) , 50.0f, TipoLocacao.SEMANAL, 2);
		
		List<Livro> livros = new ArrayList<Livro>();
		
		Editora e1 = new Editora("Martin Claret", "123456734-12", "1234-1234");
		Editora e2 = new Editora("Harper Collins", "564456734-12", "2344-6534");
		
		livros.add(new Livro("A Origem das Especies", Genero.LITERATURA_CIENTIFICA, "Charles Darwin", Idioma.PORTUGUES, e1));
		livros.add(new Livro("O Hobbit", Genero.FANTASIA, "J.R.R Tolkien", Idioma.PORTUGUES, e2));
		
		locacao.setLivros(livros);
		
		locacao.setPagamento(new Pagamento(Status.PENDENTE, Forma.CREDITO, 50.0f));
		
		Cliente cliente = new Cliente("Thiago", "23434534556", "98345-9432");
		
		cliente.adcLocacao(locacao);
		e1.adcLivro(livros.get(0));
		e2.adcLivro(livros.get(1));
		Ldao.cadastrar(livros.get(0));
		Ldao.cadastrar(livros.get(1));
		Edao.cadastrar(e1);
		Edao.cadastrar(e2);
		Cdao.cadastrar(cliente);
		try {
			Cdao.commit();
			Ldao.commit();
			Edao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro...");
		}
		
		em.close();
		fabrica.close();
	}
}
