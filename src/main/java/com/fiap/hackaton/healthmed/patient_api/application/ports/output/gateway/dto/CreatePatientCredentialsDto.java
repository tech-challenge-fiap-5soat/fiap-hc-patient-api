package com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto;

import lombok.Builder;
import java.util.UUID;

@Builder
public record CreatePatientCredentialsDto(
        UUID id,
        String name,
        String cpf,
        String email,
        String password,
        UserAuthType userType
) {}