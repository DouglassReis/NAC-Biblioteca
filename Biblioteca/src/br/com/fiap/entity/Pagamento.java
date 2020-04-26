package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_PAGAMENTO")
public class Pagamento {
	
	@Id
	@Column(name = "cd_pagamento", nullable = false)
	@SequenceGenerator(name = "codPagamento", sequenceName = "SQ_TB_PAGAMENTO", allocationSize = 1)
	@GeneratedValue(generator = "codPagamento", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "ds_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "ds_forma")
	@Enumerated(EnumType.STRING)
	private Forma formaPagamento;
	
	@Transient
	private float valorTotal;
	
	@OneToOne(mappedBy = "pagamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Locacao locacao;
	
	public float calcularValorTotal() {
		return valorTotal = locacao.getQtdLivros() * locacao.getValor();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Forma getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Forma formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pagamento(Status status, Forma formaPagamento, float valorTotal) {
		super();
		this.status = status;
		this.formaPagamento = formaPagamento;
		this.valorTotal = valorTotal;
	}
	
	
	
	
}
