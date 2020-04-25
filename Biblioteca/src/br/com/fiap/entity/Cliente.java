package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {
	
	@Id
	@Column(name = "cd_cliente", nullable = false)
	@SequenceGenerator(name = "codCliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
	@GeneratedValue(generator = "codCliente", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_cliente", nullable = false, length = 60)
	private String nome;
	
	@Column(name = "nr_cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "nmr_telefone", nullable = false, length = 11)
	private String telefone;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
