package com.LeagueSocial.Services.Exceptions;

public class DuplicatedKeyException extends RuntimeException{

    public DuplicatedKeyException(String msg){
        super(msg);
    }

    public DuplicatedKeyException(String msg, Throwable cause){
        super(msg,cause);
    }
}
