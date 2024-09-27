package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreateScheduleAppointmentUseCase;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.exceptions.BusinessException;
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
        if(!isSchedulingValid(schedulingRequest)) {
            throw new BusinessException("Invalid scheduling data");
        }
        return schedulingService.createSchedulingAppointment(schedulingRequest);
    }

    private boolean isSchedulingValid(Scheduling schedulingRequest) {
        return schedulingRequest != null &&
                schedulingRequest.getPatientId() != null
                && schedulingRequest.getDoctorId() != null
                && schedulingRequest.getDoctorScheduleId() != null
                && schedulingRequest.getSchedulingDate() != null;
    }

}