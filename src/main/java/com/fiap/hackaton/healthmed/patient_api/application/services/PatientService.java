package com.fiap.hackaton.healthmed.patient_api.application.services;

import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;

public interface PatientService {
    Patient CreatePatient(Patient patient);
}