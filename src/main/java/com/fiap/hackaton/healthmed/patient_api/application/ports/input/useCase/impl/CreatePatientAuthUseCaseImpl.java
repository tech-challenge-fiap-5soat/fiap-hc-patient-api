package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientAuthUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientAuthUseCaseImpl implements CreatePatientAuthUseCase {

    //TODO: Implement interaction with cognito-auth-api
    @Override
    public Boolean execute(Patient patient) {
        return true;
    }
}