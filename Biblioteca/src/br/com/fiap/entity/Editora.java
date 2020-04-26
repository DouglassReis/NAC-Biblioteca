package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_EDITORA")
public class Editora {
	
	@Id
	@Column(name = "cd_editora", nullable = false)
	@SequenceGenerator(name = "codEditora", sequenceName = "SQ_TB_EDITORA", allocationSize = 1)
	@GeneratedValue(generator = "codEditora", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_editora", nullable = false, length = 30)
	private String nome;
	
	@Column(name = "nr_cnpj", nullable = false, length = 14)
	private String cnpj;
	
	@Column(name = "nr_telefone", length = 11)
	private String telefone;
	
	@OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
	private List<Livro> livros = new ArrayList<Livro>();
	
	public void adcLivro(Livro livro) {
		livros.add(livro);
		livro.setEditora(this);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Editora(String nome) {
		super();
		this.nome = nome;
	}
	
	
}
