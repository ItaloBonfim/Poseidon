package com.LeagueSocial.DTO;


import com.LeagueSocial.Domain.Associates;

import java.io.Serializable;

public class AssociatesDTO implements Serializable {

    private Integer user;
    private Integer target;
    private Boolean isBlocked;


    public AssociatesDTO(Integer user, Integer target, Boolean isBlocked) {
        this.user = user;
        this.target = target;
        this.isBlocked = isBlocked;
    }
    public Integer getUser() {
        return user;
    }

    public Integer getTarget() {
        return target;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }
}
