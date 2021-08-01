package com.devsuperior.movieflix.serviceImpl.exception;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = -3439983441025439632L;

    public DatabaseException(String msg){
        super(msg);
    }
}
