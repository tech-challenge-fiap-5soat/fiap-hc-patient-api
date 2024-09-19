package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.repository;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.entity.PatientEntity;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper.PatientMapper;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.repository.jpa.JpaPatientRepository;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    @Autowired
    private JpaPatientRepository jpaPatientRepository;

    @Override
    public Patient save(Patient patient) {
        PatientEntity patientEntity = PatientMapper.PatientToPatientEntity(patient);
        PatientEntity savedEntity = jpaPatientRepository.save(patientEntity);
        return PatientMapper.PatientEntityToPatient(savedEntity);
    }
}