package com.ricardoronsoni.curso.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ricardoronsoni.curso.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L; //so precisa dessa linha. nao precisa implementar o seriable
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	//por ser uma classe filha nao precisa do hashcode e equals
	
}
