package com.fiap.hackaton.healthmed.patient_api.application.services;

import com.fiap.hackaton.healthmed.patient_api.domain.model.CreatedSchedulingAppointment;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Scheduling;

public interface SchedulingService {
    CreatedSchedulingAppointment createSchedulingAppointment(Scheduling schedulingRequest);
}