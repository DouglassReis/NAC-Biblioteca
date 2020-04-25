package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_LIVRO")
public class Livro {
	
	@Id
	@Column(name = "cd_codigo", nullable = false)
	@SequenceGenerator(name = "codLivro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
	@GeneratedValue(generator = "codLivro", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "ds_titulo", nullable = false, length = 50)
	private String titulo;
	
	@Column(name = "ds_genero", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Column(name = "nm_autor", nullable = false, length = 50)
	private String autor;
	
	@Column(name = "ds_idioma", nullable = false)
	@Enumerated(EnumType.STRING)
	private Idioma idioma;
	
	@Column(name = "fl_capa")
	@Lob
	private byte[] capa;
	
	@ManyToMany
	@JoinTable(name = "TB_LIVRO_LOCACAO", 
		joinColumns = @JoinColumn(name = "cd_livro"),
		inverseJoinColumns = @JoinColumn(name = "cd_locacao"))
	private List<Locacao> locacoes;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_editora", nullable = false)
	private Editora editora;
		
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}	
}
