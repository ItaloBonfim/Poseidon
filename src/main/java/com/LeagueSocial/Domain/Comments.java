package com.LeagueSocial.Domain;

import com.LeagueSocial.DTO.SubfieldsDTO.AccountSummaryDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;

    private Integer reactions;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Publication publication;

    public Comments(){}

    public Comments(String message, Account user, Publication publication){
        this.message = message;
        this.account = user;
        this.publication = publication;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getReactions() {
        return reactions;
    }

    public void setReactions(Integer reactions) {
        this.reactions = reactions;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public AccountSummaryDTO UserContent(Account account){
        AccountSummaryDTO commentUser = new AccountSummaryDTO(getAccount());
        return commentUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return id.equals(comments.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
