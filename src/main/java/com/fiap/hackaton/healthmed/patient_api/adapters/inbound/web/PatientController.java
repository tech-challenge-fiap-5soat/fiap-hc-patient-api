package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web;

import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.CreatePatientRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.LoginRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.PatientCreatedDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreateSchedulingRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreatedAppointment;
import com.fiap.hackaton.healthmed.patient_api.common.constants.PathConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = PathConstants.PATIENTS, produces = APPLICATION_JSON_VALUE)
public interface PatientController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<PatientCreatedDto> create(@RequestBody CreatePatientRequestDto request);

    @PostMapping(path = PathConstants.PATIENTS_SCHEDULE_APPOINTMENT, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<CreatedAppointment> scheduleAppointment(@RequestBody CreateSchedulingRequestDto createRequestDto);

    @PostMapping(path = PathConstants.PATIENTS_LOGIN , produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest);

}