package com.LeagueSocial.DTO;

import com.LeagueSocial.Domain.Category;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class CategoryDTO implements Serializable {

    private Integer id;
    private String name;

}
