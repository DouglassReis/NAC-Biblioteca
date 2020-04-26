package br.com.fiap.entity;

import java.util.Calendar;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_LOCACAO")
public class Locacao {
	
	@Id
	@Column(name = "cd_locacao", nullable = false)
	@SequenceGenerator(name = "codLocacao", sequenceName = "SQ_TB_LOCACAO", allocationSize = 1)
	@GeneratedValue(generator = "codLocacao", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "dt_inicio", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dtInicio;
	
	@Column(name = "dt_fim", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dtFim;
	
	@Column(name = "vl_locacao", nullable = false)
	private float valor;
	
	@Column(name = "ds_tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoLocacao tipo;
	
	@Column(name = "qt_livros", nullable = false)
	private int qtdLivros;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_locacao", nullable = false, unique = true)
	private Pagamento pagamento;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cd_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToMany(mappedBy = "locacoes")
	private List<Livro> livros;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Calendar dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Calendar getDtFim() {
		return dtFim;
	}

	public void setDtFim(Calendar dtFim) {
		this.dtFim = dtFim;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public TipoLocacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoLocacao tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public int getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}
	
	

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Locacao(Calendar dtInicio, Calendar dtFim, float valor, TipoLocacao tipo, int qtdLivros) {
		super();
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.valor = valor;
		this.tipo = tipo;
		this.qtdLivros = qtdLivros;
	}
	
	
}
