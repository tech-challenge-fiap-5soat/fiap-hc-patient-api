package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;

public interface LoginPatientUseCase {
    String loginAndGetAuthToken(String email, String password);
}