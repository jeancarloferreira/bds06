package com.devsuperior.movieflix.serviceImpl.exception;

public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = -573314060112521848L;

    public ForbiddenException(String msg){
        super(msg);
    }
}
