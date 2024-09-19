package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.impl;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper.DoctorMapper;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.ListDoctorUseCase;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.PatientController;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.AvailableDoctorDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.CreatePatientRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.PatientCreatedDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper.PatientMapper;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientController {

    @Autowired
    private final CreatePatientUseCase createPatientUseCase;

    @Override
    public ResponseEntity<PatientCreatedDto> create(CreatePatientRequestDto request) {
        Patient requestedPatient = PatientMapper.CreatePatientRequestDtoToPatient(request);

        Patient patientCreated = createPatientUseCase.createPatient(requestedPatient);

        PatientCreatedDto createdDto = PatientCreatedDto.builder()
                .id(patientCreated.getId())
                .name(patientCreated.getName())
                .cpf(patientCreated.getCpf())
                .email(patientCreated.getEmail())
                .build();

        return status(CREATED).body(createdDto);
    }


    @Override
    public ResponseEntity<String> scheduleAppointment(String id) {
        return null;
    }
}