package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.ListDoctorUseCase;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListDoctorUseCaseImpl implements ListDoctorUseCase {
    @Override
    public List<Doctor> listDoctors(Boolean includeWithoutSlots, String specialty) {

        if (includeWithoutSlots != null && includeWithoutSlots) {
            return List.of(Doctor.builder()
                    .id(UUID.randomUUID())
                    .name("Dr. Sem Agenda")
                    .cpf("123.456.789-00")
                    .crm("123456")
                    .email("fulano@mail.com")
                    .build(),
                    Doctor.builder()
                            .id(UUID.randomUUID())
                            .name("Dr. Fulano")
                            .cpf("123.456.789-00")
                            .crm("123456")
                            .email("fulano@mail.com")
                            .build()
                    );
        }

        return List.of(Doctor.builder()
                .id(UUID.randomUUID())
                .name("Dr. Fulano")
                .cpf("123.456.789-00")
                .crm("123456")
                .email("fulano@mail.com")
                .build());

    }
}