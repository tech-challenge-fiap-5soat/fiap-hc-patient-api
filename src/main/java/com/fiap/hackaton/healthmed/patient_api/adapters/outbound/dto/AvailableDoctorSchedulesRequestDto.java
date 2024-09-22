package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto;

import java.time.LocalDateTime;

public record AvailableDoctorSchedulesRequestDto(
        LocalDateTime date
) {
}