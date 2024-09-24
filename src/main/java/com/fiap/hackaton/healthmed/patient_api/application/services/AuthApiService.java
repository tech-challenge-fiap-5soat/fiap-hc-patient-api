package com.fiap.hackaton.healthmed.patient_api.application.services;

import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.CreatePatientCredentialsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.LoginRequestDto;

public interface AuthApiService {
    Boolean createCredentials(CreatePatientCredentialsDto createPatientCredentialsDto);
    String login(LoginRequestDto loginRequestDto);
}