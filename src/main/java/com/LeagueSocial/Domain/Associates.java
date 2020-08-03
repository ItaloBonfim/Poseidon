package com.LeagueSocial.Domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Associations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Associates implements Serializable {

    @Id
    private Integer id; // dar uma jeito de remover esse campo da entidade
    @NonNull
    @ManyToOne
    @JoinColumn(name = "pk_user")
    private Account user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "pk_target")
    private Account target;

    private Boolean isBlocked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Associates that = (Associates) o;
        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
