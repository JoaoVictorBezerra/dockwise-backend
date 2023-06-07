package com.api.containers.controller.advice;

public class BusinessException extends RuntimeException {
    public BusinessException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}