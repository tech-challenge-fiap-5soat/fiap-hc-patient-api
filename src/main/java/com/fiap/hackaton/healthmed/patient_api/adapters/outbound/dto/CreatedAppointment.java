package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreatedAppointment(
        UUID id
) {
}