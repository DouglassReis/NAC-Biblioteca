package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
