package com.vijeth.mvc.exception;

public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException(){

    }

    public BookIdMismatchException(String message){
        super(message);
    }

    public BookIdMismatchException(String message, Throwable throwable){
        super(message, throwable);
    }

}
