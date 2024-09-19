package com.fiap.hackaton.healthmed.patient_api.application.services.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.AuthApiGateway;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.CreatePatientCredentialsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.LoginRequestDto;
import com.fiap.hackaton.healthmed.patient_api.application.services.AuthApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthApiServiceImpl implements AuthApiService {

    @Autowired
    private final AuthApiGateway authApiGateway;

    @Override
    public Boolean createCredentials(CreatePatientCredentialsDto createPatientCredentialsDto) {
        return authApiGateway.createCredentials(createPatientCredentialsDto);
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        return authApiGateway.login(loginRequestDto);
    }
}