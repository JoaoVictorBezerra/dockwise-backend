package com.api.containers.controller.advice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Getter
@Setter
public class Response {
    private Date timestamp = new Date();
    private HttpStatus status;
    private int statusCode;
    private String message;

    public Response(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.statusCode = status.value();
    }
}
