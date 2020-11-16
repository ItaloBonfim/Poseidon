package com.LeagueSocial.DTO;

import com.LeagueSocial.DTO.SubfieldsDTO.AccountSummaryDTO;
import com.LeagueSocial.Domain.Comments;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommentsDTO implements Serializable {

    private String commentMessage;
    private Integer userIdentity;
    private Integer publicationId;

    private AccountSummaryDTO teste;

    public CommentsDTO(){}

    public CommentsDTO(Integer userIdentity, Integer publicationId){
        this.userIdentity = userIdentity;
        this.publicationId = publicationId;
    }

    public CommentsDTO(Integer publicationId, Integer userIdentify, String message ){
        this.userIdentity = userIdentify;
        this.publicationId = publicationId;
        this.commentMessage = message;
    }

    public CommentsDTO(Comments obj){
        this.teste = obj.UserContent(obj.getAccount());
        this.commentMessage = obj.getMessage();
        this.publicationId = obj.getId();
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public Integer getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Integer publicationId) {
        this.publicationId = publicationId;
    }

    public Integer UserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    public AccountSummaryDTO getTeste() {
        return teste;
    }

    public void setTeste(AccountSummaryDTO teste) {
        this.teste = teste;
    }
}
