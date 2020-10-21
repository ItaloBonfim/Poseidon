package com.LeagueSocial.DTO.SubfieldsDTO;

import com.LeagueSocial.Domain.Account;

import java.io.Serializable;

public class AccountSummaryDTO implements Serializable {

    private Integer userIdentity;
    private String name;

    public AccountSummaryDTO(){}
    public AccountSummaryDTO(Account obj){
        this.userIdentity = obj.getId();
        this.name = obj.getName();
    }

    public Integer getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
