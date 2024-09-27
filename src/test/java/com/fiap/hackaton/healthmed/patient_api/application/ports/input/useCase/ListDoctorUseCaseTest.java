package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl.ListDoctorUseCaseImpl;
import com.fiap.hackaton.healthmed.patient_api.application.services.DoctorApiService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.DoctorApiGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListDoctorUseCaseTest {

    @Mock
    private DoctorApiService doctorApiService;

    @InjectMocks
    private ListDoctorUseCaseImpl listDoctorUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listDoctors_includeWithoutSlotsAndSpecialty_returnsDoctors() {
        List<Doctor> expectedDoctors = List.of(new Doctor(
                UUID.fromString("f47b3b3b-3b3b-3b3b-3b3b-3b3b3b3b3b3b"),
                "Dr. Smith",
                "123123",
                "321321",
                "doctor@mail.com")
        );

        when(doctorApiService.listDoctors(true, "")).thenReturn(expectedDoctors);
        List<Doctor> actualDoctors = listDoctorUseCase.listDoctors(true, "");
        assertEquals(expectedDoctors, actualDoctors);
    }


    @Test
    void listDoctors_noDoctorsFound_returnsEmptyList() {
        when(doctorApiService.listDoctors(false, "")).thenReturn(Collections.emptyList());
        List<Doctor> actualDoctors = listDoctorUseCase.listDoctors(false, "");
        assertEquals(Collections.emptyList(), actualDoctors);
    }
}