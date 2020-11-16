package com.LeagueSocial.DTO;


import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.enums.KindSex;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class AccountDTO {

    private Integer id ;
    @NotEmpty(message = "Preenchimento obrigatorio")
    private String name;
    @NotEmpty(message = "Preenchimento obrigatorio")
    @Email(message = "Email incorreto") private String email;
    private String description;
    @NotEmpty(message = "Preenchimento obrigatorio")
    private String password;
    @NotEmpty(message = "Preenchimento obrigatorio")
    private Integer genero;

    public AccountDTO() {}
    public AccountDTO(Account obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.description = obj.getDescription();
        this.genero = obj.getKind().getCod();
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

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
