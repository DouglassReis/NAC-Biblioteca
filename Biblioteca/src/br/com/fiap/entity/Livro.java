package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
}
