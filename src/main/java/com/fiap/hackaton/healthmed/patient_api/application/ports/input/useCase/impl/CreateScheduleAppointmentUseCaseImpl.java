package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreateScheduleAppointmentUseCase;
import com.fiap.hackaton.healthmed.patient_api.application.services.SchedulingService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.CreatedSchedulingAppointment;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Scheduling;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateScheduleAppointmentUseCaseImpl implements CreateScheduleAppointmentUseCase {

    @Autowired
    private final SchedulingService schedulingService;

    @Override
    public CreatedSchedulingAppointment createSchedulingAppointment(Scheduling schedulingRequest) {
        return schedulingService.createSchedulingAppointment(schedulingRequest);
    }
}