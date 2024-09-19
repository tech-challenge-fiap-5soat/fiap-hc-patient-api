package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PatientCreatedDto(
        UUID id,
        String name,
        String cpf,
        String email
) {
}