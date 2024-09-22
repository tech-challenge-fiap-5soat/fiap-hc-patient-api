package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.impl;

import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.LoginRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreateSchedulingRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreatedAppointment;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper.SchedulingMapper;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreateScheduleAppointmentUseCase;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.LoginPatientUseCase;
import com.fiap.hackaton.healthmed.patient_api.domain.model.CreatedSchedulingAppointment;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.PatientController;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.CreatePatientRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.PatientCreatedDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper.PatientMapper;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.CreatePatientUseCase;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Scheduling;
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

    @Autowired
    private final CreateScheduleAppointmentUseCase createScheduleAppointmentUseCase;

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
    public ResponseEntity<CreatedAppointment> scheduleAppointment(CreateSchedulingRequestDto createRequestDto) {
        Scheduling appointment = SchedulingMapper.CreateSchedulingRequestDtoToScheduling(createRequestDto);
        CreatedSchedulingAppointment created = createScheduleAppointmentUseCase.createSchedulingAppointment(appointment);
        return ResponseEntity.ok(CreatedAppointment.builder().id(created.getId()).build());
    }

    @Override
    public ResponseEntity<String> login(LoginRequestDto request) {
        String authToken = loginPatientUseCase.loginAndGetAuthToken(request.email(), request.password());
        return ResponseEntity.ok(authToken);
    }
}