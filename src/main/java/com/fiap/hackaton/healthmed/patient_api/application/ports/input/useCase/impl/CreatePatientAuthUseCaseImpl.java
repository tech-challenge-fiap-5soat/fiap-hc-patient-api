package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.CreatePatientCredentialsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.UserAuthType;
import com.fiap.hackaton.healthmed.patient_api.application.services.AuthApiService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientAuthCredentialsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatePatientAuthUseCaseImpl implements CreatePatientAuthCredentialsUseCase {

    @Autowired
    private final AuthApiService authApiService;

    @Override
    public Boolean createCredentials(Patient patient) {
        if (!isPatientValid(patient)) {
            return false;
        }

        CreatePatientCredentialsDto createPatientCredentialsDto = CreatePatientCredentialsDto.
                builder()
                .name(patient.getName())
                .cpf(patient.getCpf())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .userType(UserAuthType.PATIENT)
                .build();

        return authApiService.createCredentials(createPatientCredentialsDto);
    }

    private Boolean isPatientValid(Patient patient) {
        return patient != null
                && patient.getName() != null && !patient.getName().isEmpty()
                && patient.getCpf() != null && !patient.getCpf().isEmpty()
                && patient.getEmail() != null && !patient.getEmail().isEmpty()
                && patient.getPassword() != null && !patient.getPassword().isEmpty();
    }
}