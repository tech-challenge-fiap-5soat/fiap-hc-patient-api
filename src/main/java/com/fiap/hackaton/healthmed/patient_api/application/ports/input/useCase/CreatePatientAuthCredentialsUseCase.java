package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;

public interface CreatePatientAuthCredentialsUseCase {
    Boolean createCredentials(Patient patient);
}