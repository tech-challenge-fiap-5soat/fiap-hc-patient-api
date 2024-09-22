package com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorSchedules;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorSchedulesRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreateSchedulingRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreatedAppointment;
import java.util.List;
import java.util.UUID;

public interface SchedulingApiGateway {
    CreatedAppointment createSchedulingAppointment(CreateSchedulingRequestDto createRequestDto);
    List<AvailableDoctorSchedules> availableDoctorSchedules(UUID doctorId, AvailableDoctorSchedulesRequestDto requestDto);
}