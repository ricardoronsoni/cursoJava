package com.ricardoronsoni.curso.domain.enums;

public enum TipoCliente {
	
	//entre parenteses é o codigo do item no banco e a descricao
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	//funcao é private
	private TipoCliente(int cod, String descricao) {
		this.cod= cod;
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		//o x é objeto que esta sendo varido.   "TipoCliente.values()" pede para varer todos os TipoCliente
		for(TipoCliente x : TipoCliente.values()) {
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
