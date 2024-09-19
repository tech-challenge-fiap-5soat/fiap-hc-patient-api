package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.repository.jpa;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> { }