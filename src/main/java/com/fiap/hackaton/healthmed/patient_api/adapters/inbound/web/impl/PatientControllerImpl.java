package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.LoginPatientUseCase;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.PatientController;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.CreatePatientRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.PatientCreatedDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper.PatientMapper;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientController {

    @Autowired
    private final CreatePatientUseCase createPatientUseCase;

    @Autowired
    private final LoginPatientUseCase loginPatientUseCase;

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

    @Override
    public ResponseEntity<String> login(String email, String password) {
        String authToken = loginPatientUseCase.loginAndGetAuthToken(email, password);
        return ResponseEntity.ok(authToken);
    }
}