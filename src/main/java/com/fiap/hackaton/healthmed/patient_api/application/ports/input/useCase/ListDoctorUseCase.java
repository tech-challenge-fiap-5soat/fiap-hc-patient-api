package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;

import java.util.List;

public interface ListDoctorUseCase {
    List<Doctor> listDoctors(Boolean includeWithoutSlots, String specialty);
}