package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.LoginPatientUseCase;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.AuthApiGateway;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.LoginRequestDto;
import com.fiap.hackaton.healthmed.patient_api.application.services.AuthApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginPatientUseCaseImpl implements LoginPatientUseCase {

    @Autowired
    private final AuthApiService authApiService;

    @Override
    public String loginAndGetAuthToken(String email, String password) {
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .email(email)
                .password(password)
                .build();

        return authApiService.login(loginRequestDto);
    }
}