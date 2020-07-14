package com.LeagueSocial.Domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.LeagueSocial.Domain.enums.KindSex;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;


@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_user")
	private Integer id;
	private String name;
	private String username;
	@JsonIgnore
	private Integer kind;// Codigo de genero no pacote Enums / estudar a viabilidade do campo de genero sexual
	@JsonIgnore
	private String email;
	@JsonIgnore
	private String password;
	private String description;

	@JsonIgnore
	@ElementCollection
	@CollectionTable(name = "telephone")
	private Set<String> telephone = new HashSet<>();

	public Account() {}

	public Account(Integer id, String name, String username, KindSex kind, String email, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.kind = (kind == null) ? null : kind.getCod();
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public KindSex getKind() {
		return KindSex.toEnum(kind);
	}

	public void setKind(KindSex kind) {
		this.kind = kind.getCod();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getTelephone() {
		return telephone;
	}

	public void setTelephone(Set<String> telephone) {
		this.telephone = telephone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
