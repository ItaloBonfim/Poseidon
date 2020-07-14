package com.LeagueSocial.DTO;

import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.AssociatedFollowings;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FollowingDTO implements Serializable {

    private Integer id;
    private String nome;
    private String username;

    //transformar isso num DTO, retornando conta inteira
    private List<AssociatedFollowings> listFollowing = new ArrayList<>();

    public FollowingDTO(){}

    public FollowingDTO(Integer id, String nome, String username, List<AssociatedFollowings> listFollowing) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.listFollowing = listFollowing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AssociatedFollowings> getListFollowing() {
        return listFollowing;
    }

    public void setListFollowing(List<AssociatedFollowings> listFollowing) {
        this.listFollowing = listFollowing;
    }
}
