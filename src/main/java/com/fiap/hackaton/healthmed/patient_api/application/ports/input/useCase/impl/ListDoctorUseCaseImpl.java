package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.ListDoctorUseCase;
import com.fiap.hackaton.healthmed.patient_api.application.services.DoctorApiService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListDoctorUseCaseImpl implements ListDoctorUseCase {
    @Autowired
    private final DoctorApiService doctorApiService;

    @Override
    public List<Doctor> listDoctors(Boolean includeWithoutSlots, String specialty) {
        return doctorApiService.listDoctors(includeWithoutSlots, specialty);
    }
}