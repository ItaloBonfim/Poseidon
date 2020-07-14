package com.LeagueSocial.Domain.enums;

public enum KindSex {
	
	MASCULINO(1, "Masculino"), FEMININO(2, "Feminino"), PERSONALIZADO(3, "Personalizado");
	
	private int cod;
	private String description;

	KindSex(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static KindSex toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(KindSex x : KindSex.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: " +cod);
	}
}
