package com.scaler.demo.project.service;

import org.springframework.http.HttpStatus;

public class FakeStoreExceptionHandler extends RuntimeException{

    private String message;
    private HttpStatus status;
    private String devMessage;

    public FakeStoreExceptionHandler() { super();}

    public FakeStoreExceptionHandler(String message, Throwable cause, HttpStatus status, String devMessage) {
        super(message, cause);
        this.message = message;
        this.status = status;
        this.devMessage = devMessage;
    }
        public FakeStoreExceptionHandler(String message, HttpStatus status, String devMessage){
            super(message);
            this.message = message;
            this.status = status;
            this.devMessage = devMessage;
        }

        public FakeStoreExceptionHandler(Throwable cause, String message, HttpStatus status, String devMessage){
        super(cause);
            this.message = message;
            this.status = status;
            this.devMessage = devMessage;
        }
    }
