package com.LeagueSocial.DTO;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserAuthenticateDTO implements Serializable {

    @NotEmpty(message = "O espaço está em branco")
    private String email;
    @NotEmpty(message = "O espaço está em branco")
    private String password;

    public UserAuthenticateDTO(){}

//     public UserAuthenticateDTO(String email, String password){
//        this.email = email;
//        this.password = password;
//    }

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
