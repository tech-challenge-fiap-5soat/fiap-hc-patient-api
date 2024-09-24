package com.fiap.hackaton.healthmed.patient_api.application.ports.output.repository;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;


public interface PatientRepository {
    Patient save(Patient patient);
}