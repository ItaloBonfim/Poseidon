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


}
