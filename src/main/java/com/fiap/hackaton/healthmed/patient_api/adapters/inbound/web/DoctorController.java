package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web;

import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.AvailableDoctorDto;
import com.fiap.hackaton.healthmed.patient_api.common.constants.PathConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = PathConstants.DOCTORS, produces = APPLICATION_JSON_VALUE)
public interface DoctorController {
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<AvailableDoctorDto>> listDoctors(@RequestParam(required = false) Boolean includeWithoutSlots,
                                                         @RequestParam(required = false) String specialty);
}