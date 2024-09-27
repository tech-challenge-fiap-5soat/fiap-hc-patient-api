package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;


import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.exceptions.BusinessException;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl.CreatePatientAuthUseCaseImpl;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl.CreatePatientUseCaseImpl;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.CreatePatientCredentialsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.UserAuthType;
import com.fiap.hackaton.healthmed.patient_api.application.services.AuthApiService;
import com.fiap.hackaton.healthmed.patient_api.application.services.PatientService;
import com.fiap.hackaton.healthmed.patient_api.application.services.impl.AuthApiServiceImpl;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CreatePatientUseCaseTest {

    @Mock
    private PatientService patientService;

    @Mock
    private AuthApiServiceImpl authApiService;

    @InjectMocks
    private CreatePatientAuthUseCaseImpl createPatientAuthUseCase;

    @InjectMocks
    private CreatePatientUseCaseImpl createPatientUseCaseImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createPatientUseCaseImpl = new CreatePatientUseCaseImpl(patientService, createPatientAuthUseCase);
    }

    @Test
    void createPatient_validPatient_returnsCreatedPatient() {
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
        when(patientService.CreatePatient(patient)).thenReturn(patient);

        Patient createdPatient = createPatientUseCaseImpl.createPatient(patient);
        assertEquals(patient, createdPatient);
    }


    @Test
    void createPatient_patientWithEmptyName_thownBusinessException() {
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
        when(patientService.CreatePatient(patient)).thenReturn(patient);

        assertThrows(BusinessException.class, () -> {
            createPatientUseCaseImpl.createPatient(patient);
        });
    }

    @Test
    void createPatient_patientWithEmptyEmail_thownBusinessException() {
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
        when(patientService.CreatePatient(patient)).thenReturn(patient);

        assertThrows(BusinessException.class, () -> {
            createPatientUseCaseImpl.createPatient(patient);
        });
    }

    @Test
    void createPatient_patientWithNullName_thownBusinessException() {
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
        when(patientService.CreatePatient(patient)).thenReturn(patient);

        assertThrows(BusinessException.class, () -> {
            createPatientUseCaseImpl.createPatient(patient);
        });
    }

    @Test
    void createPatient_patientWithNullEmail_thownBusinessException() {
        Patient patient = new Patient(
                UUID.fromString("f47b3b3d-3b1b-4b4b-8b1b-3b4b1b4b1b4b"),
                null,
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
        when(patientService.CreatePatient(patient)).thenReturn(patient);

        assertThrows(BusinessException.class, () -> {
            createPatientUseCaseImpl.createPatient(patient);
        });
    }
}