package com.LeagueSocial.DTO;


import com.LeagueSocial.Domain.Publication;
import com.LeagueSocial.Resources.Profile.CommentsProfileResource;
import com.LeagueSocial.Services.Profile.CommentsProfileService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PublicationDTO implements Serializable {

    private Integer id;
    private String message;
    private Date date;

    private Integer userIdentity;
    private List<?> userContent; // aceeso direto aos atributos do usuario


    public PublicationDTO(){}

    public PublicationDTO(Publication obj){
        this.id = obj.getId();
        this.message = obj.getMessage();
        this.date = obj.getDate();

        this.userContent = obj.UserPublicationContent(obj.getUser()); //funcional

        //this.commentsList = obj.getComments();
    }

    public PublicationDTO(Integer userIdentity, String content){
        this.userIdentity = userIdentity;
        this.message = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer UserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    public List<?> getUserContent() {
        return userContent;
    }

    public void setUserContent(List<?> userContent) {
        this.userContent = userContent;
    }

}
