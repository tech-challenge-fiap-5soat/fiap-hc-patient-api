package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.persistence.mapper;

import com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto.AvailableDoctorDto;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorMapper {
    public static AvailableDoctorDto toAvailableDoctorDto(Doctor doctor) {
        return AvailableDoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .crm(doctor.getCrm())
                .email(doctor.getEmail())
                .build();
    }

    public static List<AvailableDoctorDto> toAvailableDoctorDtoList(List<Doctor> doctors) {
        return doctors.stream()
                .map(DoctorMapper::toAvailableDoctorDto)
                .collect(Collectors.toList());
    }
}