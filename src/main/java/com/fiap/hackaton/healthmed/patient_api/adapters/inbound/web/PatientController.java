package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web;

import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.CreatePatientRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.PatientCreatedDto;
import com.fiap.hackaton.healthmed.patient_api.common.constants.PathConstants;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.AvailableDoctorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = PathConstants.PATIENTS, produces = APPLICATION_JSON_VALUE)
public interface PatientController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<PatientCreatedDto> create(@RequestBody CreatePatientRequestDto request);

    @GetMapping(path = PathConstants.PATIENTS_SCHEDULE_APPOINTMENT, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> scheduleAppointment(String id);

    @PostMapping(path = PathConstants.PATIENTS_LOGIN , produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> login(@RequestParam String email, @RequestParam String password);

}