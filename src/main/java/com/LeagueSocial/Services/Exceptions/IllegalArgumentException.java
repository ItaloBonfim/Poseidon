package com.LeagueSocial.Services.Exceptions;

public class IllegalArgumentException extends RuntimeException {

  public IllegalArgumentException(String msg){super(msg);}

  public IllegalArgumentException(String msg, Throwable cause){super(msg);}
}
