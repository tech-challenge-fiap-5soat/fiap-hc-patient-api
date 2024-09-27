package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}