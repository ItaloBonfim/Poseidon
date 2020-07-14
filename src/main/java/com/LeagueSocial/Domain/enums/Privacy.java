package com.LeagueSocial.Domain.enums;

public enum Privacy {

	PUBLICA(1, "Publica"), AMIGOS(2, "Amigos"), SELECIONADO(3, "Apenas");
	
	private Integer cod;
	private String description;

	Privacy(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Privacy toEnum(Integer cod) {

		if(cod == null) {
			return null;
		}
		for(Privacy x : Privacy.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: " + cod);
	}
}
