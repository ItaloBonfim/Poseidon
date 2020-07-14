package com.LeagueSocial.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.LeagueSocial.Domain.enums.Privacy;


public class Publication {

	private Integer id;
	private String text;
	private String midia; // Imagem / videos - mas a pergunta é como?
	private Date time;

	private Privacy privacy; //enumerado
	private List<Account> accounts = new ArrayList<>();


	public Publication(Integer id, String text, String midia, Date time, Privacy privacy) {
		this.id = id;
		this.text = text;
		this.midia = midia;
		this.time = time;
		this.privacy = privacy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

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
