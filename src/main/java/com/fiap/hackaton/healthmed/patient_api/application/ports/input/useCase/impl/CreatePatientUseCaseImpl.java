package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.application.services.PatientService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientAuthCredentialsUseCase;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientUseCaseImpl implements CreatePatientUseCase {

    @Autowired
    private final PatientService patientService;

    @Autowired
    private final CreatePatientAuthCredentialsUseCase createPatientAuthUseCase;

    public CreatePatientUseCaseImpl(PatientService patientService,
                                     CreatePatientAuthCredentialsUseCase createPatientAuthUseCase) {

        this.patientService = patientService;
        this.createPatientAuthUseCase = createPatientAuthUseCase;
    }

    public Patient createPatient(Patient patient) {
        Boolean authCreated = createPatientAuthUseCase.createCredentials(patient);
        if (!authCreated) {
            throw new RuntimeException("Error creating Patient auth credentials");
        }
        return patientService.CreatePatient(patient);
    }
}