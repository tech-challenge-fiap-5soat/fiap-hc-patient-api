package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto;

import java.util.UUID;

public record AvailableDoctorsDto(UUID id,
                               String name,
                               String crm,
                               String cpf,
                               String email) {
}