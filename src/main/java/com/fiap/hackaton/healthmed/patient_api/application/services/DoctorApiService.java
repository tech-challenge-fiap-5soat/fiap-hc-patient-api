package com.fiap.hackaton.healthmed.patient_api.application.services;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;

import java.util.List;

public interface DoctorApiService {
    List<Doctor> listDoctors(Boolean includeWithoutSlots, String specialty);
}