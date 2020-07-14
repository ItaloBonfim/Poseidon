package com.LeagueSocial.DTO;

import com.LeagueSocial.Domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "The category field can't not empty, please, verify and try again")
    @Length(min = 3, max = 20)
    private String name;

    public CategoryDTO(){}

    public CategoryDTO(Category obj){
        this.id = obj.getId();
        this.name = obj.getName();
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
}
