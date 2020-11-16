package com.LeagueSocial.Domain.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"), USER(2, "ROLE_USER");

	private int cod;
	private String description;

	Perfil(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Perfil toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: " +cod);
	}
}
