package com.LeagueSocial.DTO;

import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.enums.KindSex;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
//this class is used to update, delete and select
public class AccountDTO implements Serializable {

    private Integer id;
    private String name;
    private String username;
    private Integer kind;
    private String email; // -> o usuario não pode alterar seu email cadastrado
    private String password;

    /*
    informaçoes complementares (telephone, cidade, endereço) devem ser incluidas e atualizadas posteriormente
     */
    public AccountDTO(){}
    public AccountDTO(Account obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.username = obj.getUsername();
        this.kind = obj.getKind().getCod();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
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
    public void setKind(Integer kind) {
        this.kind = kind;
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

}
