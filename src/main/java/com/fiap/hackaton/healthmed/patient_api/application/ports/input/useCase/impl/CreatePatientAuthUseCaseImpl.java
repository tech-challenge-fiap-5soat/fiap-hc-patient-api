package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientAuthCredentialsUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientAuthUseCaseImpl implements CreatePatientAuthCredentialsUseCase {

    //TODO: Implement interaction with cognito-auth-api
    @Override
    public Boolean createCredentials(Patient patient) {
        return true;
    }
}