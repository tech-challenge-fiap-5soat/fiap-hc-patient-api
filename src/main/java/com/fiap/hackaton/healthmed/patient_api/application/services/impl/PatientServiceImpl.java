package com.fiap.hackaton.healthmed.patient_api.application.services.impl;

import com.fiap.hackaton.healthmed.patient_api.application.services.PatientService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient CreatePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}