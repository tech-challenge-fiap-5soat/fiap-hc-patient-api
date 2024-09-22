package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record AvailableDoctorSchedules(
        UUID doctorId,
        UUID doctorScheduleId,
        LocalDateTime scheduleDate,
        LocalDateTime scheduleStartTime,
        LocalDateTime scheduleEndTime
) {
}