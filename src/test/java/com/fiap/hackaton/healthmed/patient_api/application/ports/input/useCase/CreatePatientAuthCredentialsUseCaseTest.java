package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;


import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl.CreatePatientAuthUseCaseImpl;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.CreatePatientCredentialsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.UserAuthType;
import com.fiap.hackaton.healthmed.patient_api.application.services.impl.AuthApiServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CreatePatientAuthCredentialsUseCaseTest {

    @Mock
    private AuthApiServiceImpl authApiService;

    @InjectMocks
    private CreatePatientAuthUseCaseImpl createPatientAuthUseCaseImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCredentials_validPatient_returnsTrue() {
        Patient patient = new Patient(
                UUID.fromString("f47b3b3d-3b1b-4b4b-8b1b-3b4b1b4b1b4b"),
                "John Doe",
                "123123123",
                "patient@mail.com",
                "password1",
                null,
                null
        );

        CreatePatientCredentialsDto dto = CreatePatientCredentialsDto.builder()
                .name(patient.getName())
                .cpf(patient.getCpf())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .userType(UserAuthType.PATIENT)
                .build();

        when(authApiService.createCredentials(dto)).thenReturn(true);

        Boolean result = createPatientAuthUseCaseImpl.createCredentials(patient);
        assertTrue(result);
    }

    @Test
    void createCredentials_patientWithEmptyName_then_returnFalse() {
        Patient patient = new Patient(
                UUID.fromString("f47b3b3d-3b1b-4b4b-8b1b-3b4b1b4b1b4b"),
                "",
                "123123123",
                "patient@mail.com",
                "password1",
                null,
                null
        );

        CreatePatientCredentialsDto dto = CreatePatientCredentialsDto.builder()
                .name(patient.getName())
                .cpf(patient.getCpf())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .userType(UserAuthType.PATIENT)
                .build();

        when(authApiService.createCredentials(dto)).thenReturn(true);
        Boolean subject = createPatientAuthUseCaseImpl.createCredentials(patient);
        assertFalse(subject);
    }

    @Test
    void createCredentials_patientWithEmptyEmail_then_returnFalse() {
        Patient patient = new Patient(
                UUID.fromString("f47b3b3d-3b1b-4b4b-8b1b-3b4b1b4b1b4b"),
                "John Doe",
                "123123123",
                "",
                "password1",
                null,
                null
        );

        CreatePatientCredentialsDto dto = CreatePatientCredentialsDto.builder()
                .name(patient.getName())
                .cpf(patient.getCpf())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .userType(UserAuthType.PATIENT)
                .build();

        when(authApiService.createCredentials(dto)).thenReturn(true);

        Boolean subject = createPatientAuthUseCaseImpl.createCredentials(patient);
        assertFalse(subject);
    }

    @Test
    void createCredentials_patientWithNullName_then_returnFalse() {
        Patient patient = new Patient(
                UUID.fromString("f47b3b3d-3b1b-4b4b-8b1b-3b4b1b4b1b4b"),
                null,
                "123123123",
                "patient@mail.com",
                "password1",
                null,
                null
        );

        CreatePatientCredentialsDto dto = CreatePatientCredentialsDto.builder()
                .name(patient.getName())
                .cpf(patient.getCpf())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .userType(UserAuthType.PATIENT)
                .build();

        when(authApiService.createCredentials(dto)).thenReturn(true);

        Boolean subject = createPatientAuthUseCaseImpl.createCredentials(patient);
        assertFalse(subject);
    }

    @Test
    void createCredentials_patientWithNullEmail_then_returnFalse() {
        Patient patient = new Patient(
                UUID.fromString("f47b3b3d-3b1b-4b4b-8b1b-3b4b1b4b1b4b"),
                "John Doe",
                "123123123",
                null,
                "password1",
                null,
                null
        );

        CreatePatientCredentialsDto dto = CreatePatientCredentialsDto.builder()
                .name(patient.getName())
                .cpf(patient.getCpf())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .userType(UserAuthType.PATIENT)
                .build();

        when(authApiService.createCredentials(dto)).thenReturn(true);
        Boolean subject = createPatientAuthUseCaseImpl.createCredentials(patient);
        assertFalse(subject);
    }
}