package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper;

import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.CreatePatientRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.PatientCreatedDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.entity.PatientEntity;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;

public class PatientMapper {
    public static PatientEntity CreatePatientRequestDtoToEntity(CreatePatientRequestDto createPatientRequestDto) {
        return PatientEntity.builder()
                .name(createPatientRequestDto.name())
                .cpf(createPatientRequestDto.cpf())
                .email(createPatientRequestDto.email())
                .build();
    }

    public static Patient PatientEntityToPatient(PatientEntity patientEntity) {
        return Patient.builder()
                .id(patientEntity.getId())
                .name(patientEntity.getName())
                .cpf(patientEntity.getCpf())
                .email(patientEntity.getEmail())
                .build();
    }

    public static PatientEntity PatientToPatientEntity(Patient patient) {
        return PatientEntity.builder()
                .name(patient.getName())
                .cpf(patient.getCpf())
                .email(patient.getEmail())
                .build();
    }

    public static PatientCreatedDto toCreatedDto(PatientEntity patientEntity) {
        return PatientCreatedDto.builder()
                .id(patientEntity.getId())
                .name(patientEntity.getName())
                .cpf(patientEntity.getCpf())
                .email(patientEntity.getEmail())
                .build();
    }

    public static Patient CreatePatientRequestDtoToPatient(CreatePatientRequestDto createPatientRequestDto) {
        return Patient.builder()
                .name(createPatientRequestDto.name())
                .cpf(createPatientRequestDto.cpf())
                .email(createPatientRequestDto.email())
                .password(createPatientRequestDto.password())
                .build();
    }
}