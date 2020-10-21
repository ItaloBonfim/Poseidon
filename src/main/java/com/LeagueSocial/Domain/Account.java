package com.LeagueSocial.Domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.LeagueSocial.DTO.AccountDTO;
import com.LeagueSocial.DTO.SubfieldsDTO.AccountSummaryDTO;
import com.LeagueSocial.Domain.enums.KindSex;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private Integer kind;

	@NonNull
	private String email;

	@NonNull
	private String password;

	private String description;

	@JsonIgnore
	@ElementCollection
	@CollectionTable(name = "telephone")
	private Set<String> telephone = new HashSet<>();

	//como tipo de usuario seguindo
	@JsonIgnore
	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<Associates> ass = new ArrayList<>();

	//como tipo de usuario seguido
	@JsonIgnore
	@OneToMany(mappedBy = "target", orphanRemoval = true)
	private List<Associates> ons = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "user")
	private List<Publication> publications = new ArrayList<>();
	
	public void setSexualType(KindSex typeS){
		this.kind = typeS.getCod();
	}
	public KindSex getSexualType(){
		return KindSex.toEnum(kind);
	}


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
}
