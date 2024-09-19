package com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto;

import lombok.Builder;

@Builder
public record LoginRequestDto(
        String email,
        String password
) {
}