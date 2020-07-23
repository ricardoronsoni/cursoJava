package com.ricardoronsoni.curso.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	//funcao é private
	private EstadoPagamento(int cod, String descricao) {
		this.cod= cod;
		this.descricao = descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		//o x é objeto que esta sendo varido.   "TipoCliente.values()" pede para varer todos os TipoCliente
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		//se nao achar nenhum valor no for
		//exception do proprio java
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}

	//possui somente get
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

}
