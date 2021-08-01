package com.devsuperior.movieflix.serviceImpl.exception;

public class AnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = 2925526498570052819L;

    public AnauthorizedException(String msg){
        super(msg);
    }
}
