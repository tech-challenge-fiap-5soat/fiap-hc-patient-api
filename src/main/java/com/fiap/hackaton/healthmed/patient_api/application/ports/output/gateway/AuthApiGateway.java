package com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway;

import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.CreatePatientCredentialsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.LoginRequestDto;

public interface AuthApiGateway {
    Boolean createCredentials(CreatePatientCredentialsDto createPatientCredentialsDto);
    String login(LoginRequestDto loginRequestDto);
}