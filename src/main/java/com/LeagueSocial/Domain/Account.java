package com.LeagueSocial.Domain;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.*;

import com.LeagueSocial.DTO.SubfieldsDTO.AccountSummaryDTO;
import com.LeagueSocial.Domain.enums.KindSex;
import com.LeagueSocial.Domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Integer kind;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	private String description;

	@ElementCollection
	@CollectionTable(name = "telephone")
	private Set<String> telephone = new HashSet<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Perfil")
	private Set<Integer> perfis = new HashSet<>();

	//ASSOCIATIONS WITH OTHERS CLASSES WITHOUT GET AND SETTER, WE DON'T WANT ANY MORE PARAMATERS IN REQUESTS
	//como tipo de usuario seguindo
	@JsonIgnore
	@OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Associates> ass = new ArrayList<>();

	//como tipo de usuario seguido
	@JsonIgnore
	@OneToMany(mappedBy = "target", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Associates> ons = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Publication> publications = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "account",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Comments> comments = new ArrayList<>();

	// TEMPLATE CONSTRUCTORS
	public Account(){
		addPerfil(Perfil.USER);
	}

	//simple Account Instant
	public Account(Integer id, String name, String email, String password, KindSex generoS, String description){
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.kind = (kind == null) ? null : generoS.getCod();
		this.description = description;
		addPerfil(Perfil.USER);
	}
	//Simple Constructor to method create account on platform
	public Account(String name,String description, String email, String password, KindSex generoS){
		this.name = name;
		this.description = description;
		this.email = email;
		this.password = password;
		this.kind = generoS.getCod();
		this.description = description;
		addPerfil(Perfil.USER);
	}

	//GETTERS AND SETTERS METHODS
	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public void addPerfil(Perfil perfil){
		perfis.add(perfil.getCod());
	}

	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}


	//COMPLEMENTARY MEETHODS
	public void setSexualType(KindSex typeS){
		this.kind = typeS.getCod();
	}
	public KindSex getSexualType(){
		return KindSex.toEnum(kind);
	}

	//MÉTODO INUTIL ATÉ O MOMENTO
	public List<AccountSummaryDTO> ReturnSummary(Account userContent){
		AccountSummaryDTO content = new AccountSummaryDTO(userContent);

		List<AccountSummaryDTO> summaryDTO = new ArrayList<>();
		summaryDTO.add(content);

		return summaryDTO;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		 String gr = "pronto(a)";
		if(getSexualType().getCod() == 1){
			gr = "pronto";
		}else if(getSexualType().getCod() == 2){
			gr = "pronta";
		}

		sb.append("Olá " + getName() + " ");
		sb.append("Bem Vindo à SocialMediaStrems!\n");
		sb.append("Muitas pessoas estão te aguardando " +getName()+", além disso, esteja "+gr+ " ");
		sb.append("para entrar em uma network com " +
				"diversas pessoas compartilhando e comentando conteudo de stream's e jogos!\n");
		sb.append("Encarecidamente, também nos te encorajamos a avaliar a plataforma e nos fornecer seu feedback pois com isso podemos melhorar nossos seviços com a comunidade!\n");
		sb.append("Estamos te aguardando, venha!");
		sb.append("\n");

		sb.append("AVISO\n");
		sb.append("Caso você tenha recebido esse email e acredita estar havendo, entre em contato através do email\n");
		sb.append("unknowFakesmsg@gmail.com");

		return sb.toString();
	}
}
