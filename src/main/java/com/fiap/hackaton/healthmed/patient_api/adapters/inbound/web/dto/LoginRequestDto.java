package com.fiap.hackaton.healthmed.patient_api.adapters.inbound.web.dto;


import lombok.Builder;

@Builder
public record LoginRequestDto(String email, String password) {
}