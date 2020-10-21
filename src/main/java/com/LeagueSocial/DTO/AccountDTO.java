package com.LeagueSocial.DTO;


import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.enums.KindSex;

import java.io.Serializable;

public class AccountDTO {

    private Integer id ;
    private String name;
    private String email;
    private String description;
    private KindSex genero;

    public AccountDTO() {}
    public AccountDTO(Account obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.description = obj.getDescription();
        this.genero = obj.getSexualType();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public KindSex getGenero() {
        return genero;
    }

    public void setGenero(KindSex genero) {
        this.genero = genero;
    }

}
