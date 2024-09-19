package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDoctorDto {
    private UUID id;
    private String name;
    private String cpf;
    private String crm;
    private String email;
}