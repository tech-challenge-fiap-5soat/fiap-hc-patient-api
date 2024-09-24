package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreateSchedulingRequestDto;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Scheduling;

public class SchedulingMapper {
    public static Scheduling CreateSchedulingRequestDtoToScheduling(CreateSchedulingRequestDto schedulingDto) {
        return Scheduling.builder()
                .patientId(schedulingDto.patientId())
                .doctorId(schedulingDto.doctorId())
                .doctorScheduleId(schedulingDto.doctorScheduleId())
                .schedulingDate(schedulingDto.schedulingDate())
                .build();
    }
}