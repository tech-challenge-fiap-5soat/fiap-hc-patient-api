package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.gateway;

import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.CoreApiGateway;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CoreApiClient implements CoreApiGateway {

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