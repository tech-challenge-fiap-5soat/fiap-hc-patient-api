package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.impl;

import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.DoctorController;
import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.AvailableDoctorDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper.DoctorMapper;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.ListDoctorUseCase;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class DoctorControllerImpl implements DoctorController {

    @Autowired
    private final ListDoctorUseCase listDoctorUseCase;

    @Override
    public ResponseEntity<List<AvailableDoctorDto>> listDoctors(@RequestParam(required = false) Boolean includeWithoutSlots,
                                                                @RequestParam(required = false) String specialty) {

        List<Doctor> availableDoctors = listDoctorUseCase.listDoctors(includeWithoutSlots, specialty);
        List<AvailableDoctorDto> availableDoctorDto = DoctorMapper.toAvailableDoctorDtoList(availableDoctors);
        return ResponseEntity.ok(availableDoctorDto);
    }

}