package com.LeagueSocial.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Blocked")
public class AssociatedBlocked  implements Serializable {

    @Id
    private Integer id;

    @OneToOne
    private Account user;

    @ManyToOne
    private Account targetId;

    public AssociatedBlocked(){}

    public AssociatedBlocked(Integer id, Account user, Account targetId) {
        this.id = id;
        this.user = user;
        this.targetId = targetId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public Account getTargetId() {
        return targetId;
    }

    public void setTargetId(Account targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssociatedBlocked that = (AssociatedBlocked) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
