package com.fiap.hackaton.healthmed.patient_api.application.services.impl;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.DoctorApiGateway;
import com.fiap.hackaton.healthmed.patient_api.application.services.DoctorApiService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorApiServiceImpl implements DoctorApiService {

    @Autowired
    private final DoctorApiGateway doctorApiGateway;

    @Override
    public List<Doctor> listDoctors(Boolean includeWithoutSlots, String specialty) {
        List<AvailableDoctorsDto> availableDoctorsDtos = doctorApiGateway.listDoctors();
        return dtoListToDoctorsList(availableDoctorsDtos);
    }

    private List<Doctor> dtoListToDoctorsList(List<AvailableDoctorsDto> availableDoctorsDtos) {
        return availableDoctorsDtos.stream()
                .map(availableDoctorsDto -> Doctor.builder()
                        .id(availableDoctorsDto.id())
                        .name(availableDoctorsDto.name())
                        .crm(availableDoctorsDto.crm())
                        .cpf(availableDoctorsDto.cpf())
                        .email(availableDoctorsDto.email())
                        .build())
                .toList();
    }
}