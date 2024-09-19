package com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;

import java.util.List;

public interface CoreApiGateway {
    List<Doctor> listDoctors(Boolean includeWithoutSlots, String specialty);
}