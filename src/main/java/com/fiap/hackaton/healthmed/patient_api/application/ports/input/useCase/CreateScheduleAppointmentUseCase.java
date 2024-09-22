package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;

import com.fiap.hackaton.healthmed.patient_api.domain.model.CreatedSchedulingAppointment;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Scheduling;

public interface CreateScheduleAppointmentUseCase {
    CreatedSchedulingAppointment createSchedulingAppointment(Scheduling schedulingRequest);
}