package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto;

import lombok.Builder;

@Builder
public record CreatePatientRequestDto(
        String name,
        String cpf,
        String email,
        String password
) {
}