package com.LeagueSocial.Domain;


import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.DTO.SubfieldsDTO.AccountSummaryDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Publication implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany
	@JoinTable(name = "ORIGIN_PUBLICATIONS",
			joinColumns = @JoinColumn(name = "PUBLICATION"),
			inverseJoinColumns = @JoinColumn(name = "USER"))
	private List<Account> user = new ArrayList<>();

	private String message;

	private Date date;

	@OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
	private List <Comments> comments = new ArrayList<>();

	private Integer reactions;

	public Publication(){}
	public Publication(Integer id, String message, Date date) {
		this.id = id;
		this.message = message;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getReactions() {
		return reactions;
	}

	public void setReactions(Integer reactions) {
		this.reactions = reactions;
	}

	public List<Account> getUser() {
		return user;
	}

	public void setUser(List<Account> user) {
		this.user = user;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<AccountSummaryDTO> UserPublicationContent(List<Account> accountList){

		AccountSummaryDTO obj = new AccountSummaryDTO();

		for(Account resultSet : accountList) {
			//System.out.println(resultSet.getId());
			obj.setUserIdentity(resultSet.getId());
			//System.out.println(resultSet.getName());
			obj.setName(resultSet.getName());
		}

		List<AccountSummaryDTO> ListOfObject = new ArrayList<>();

		ListOfObject.add(obj);

		return ListOfObject;
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
