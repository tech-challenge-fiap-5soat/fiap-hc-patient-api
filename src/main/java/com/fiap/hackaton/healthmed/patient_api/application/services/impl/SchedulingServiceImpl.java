package com.fiap.hackaton.healthmed.patient_api.application.services.impl;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreateSchedulingRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreatedAppointment;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.SchedulingApiGateway;
import com.fiap.hackaton.healthmed.patient_api.application.services.SchedulingService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.CreatedSchedulingAppointment;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Scheduling;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private final SchedulingApiGateway schedulingApiGateway;

    public CreatedSchedulingAppointment createSchedulingAppointment(Scheduling schedulingRequest) {
        CreateSchedulingRequestDto createSchedulingRequestDto = SchedulingToCreateSchedulingRequestDto(schedulingRequest);
        CreatedAppointment created = schedulingApiGateway.createSchedulingAppointment(createSchedulingRequestDto);
        return CreatedSchedulingAppointment.builder().id(created.id()).build();
    }

    private CreateSchedulingRequestDto SchedulingToCreateSchedulingRequestDto(Scheduling schedulingRequest) {
        return CreateSchedulingRequestDto.builder()
                .patientId(schedulingRequest.getPatientId())
                .doctorId(schedulingRequest.getDoctorId())
                .doctorScheduleId(schedulingRequest.getDoctorScheduleId())
                .schedulingDate(schedulingRequest.getSchedulingDate())
                .build();
    }
}