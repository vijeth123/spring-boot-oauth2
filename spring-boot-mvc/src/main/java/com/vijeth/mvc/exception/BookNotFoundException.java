package com.vijeth.mvc.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message){
        super(message);
    }

    public BookNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

}
