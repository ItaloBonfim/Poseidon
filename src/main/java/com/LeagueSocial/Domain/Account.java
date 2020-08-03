package com.LeagueSocial.Domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.LeagueSocial.Domain.enums.KindSex;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Data
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_user")
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String username;

	@NonNull
	private Integer kind;// Codigo de genero no pacote Enums / estudar a viabilidade do campo de genero sexual

	@NonNull
	private String email;

	@NonNull
	private String password;

	private String description;

	@JsonIgnore
	@ElementCollection
	@CollectionTable(name = "telephone")
	private Set<String> telephone = new HashSet<>();


	public void setSexualType(KindSex typeS){
		this.kind = typeS.getCod();
	}
	public KindSex getSexualType(){
		return KindSex.toEnum(kind);
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
