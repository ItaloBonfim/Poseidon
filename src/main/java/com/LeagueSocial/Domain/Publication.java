package com.LeagueSocial.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.LeagueSocial.Domain.enums.Privacy;
import lombok.*;

import javax.persistence.Entity;

public class Publication {

	private Integer id;
	private String text;
	private String midia; // Imagem / videos - mas a pergunta é como?
	private Date time;

	private Privacy privacy; //enumerado
	private List<Account> accounts = new ArrayList<>();


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Publication that = (Publication) o;
		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
