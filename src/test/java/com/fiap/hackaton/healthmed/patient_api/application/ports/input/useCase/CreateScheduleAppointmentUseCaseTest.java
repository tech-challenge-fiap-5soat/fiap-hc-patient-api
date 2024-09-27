package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl.CreateScheduleAppointmentUseCaseImpl;
import com.fiap.hackaton.healthmed.patient_api.domain.model.CreatedSchedulingAppointment;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Scheduling;
import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.exceptions.BusinessException;
import com.fiap.hackaton.healthmed.patient_api.application.services.SchedulingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CreateScheduleAppointmentUseCaseTest {

    @Mock
    private SchedulingService schedulingService;

    @InjectMocks
    private CreateScheduleAppointmentUseCaseImpl createScheduleAppointmentUseCaseImpl;

    private UUID schedulingId;
    private UUID doctorId;
    private UUID patientId;
    private UUID doctorScheduleId;
    private LocalDateTime schedulingDate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        schedulingId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        doctorId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        patientId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        doctorScheduleId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        schedulingDate = LocalDateTime.parse("2023-10-10T10:00:00");
    }

    @Test
    void createSchedulingAppointment_validScheduling_returnsCreatedSchedulingAppointment() {
        Scheduling schedulingRequest = new Scheduling(
            null,
            doctorId,
            patientId,
            doctorScheduleId,
            schedulingDate
        );
        CreatedSchedulingAppointment createdSchedulingAppointment = CreatedSchedulingAppointment.builder().id(schedulingId).build();

        when(schedulingService.createSchedulingAppointment(schedulingRequest)).thenReturn(createdSchedulingAppointment);

        CreatedSchedulingAppointment result = createScheduleAppointmentUseCaseImpl.createSchedulingAppointment(schedulingRequest);
        assertEquals(createdSchedulingAppointment, result);
    }

    @Test
    void createSchedulingAppointment_nullScheduling_throwsBusinessException() {
        assertThrows(BusinessException.class, () -> {
            createScheduleAppointmentUseCaseImpl.createSchedulingAppointment(null);
        });
    }

    @Test
    void createSchedulingAppointment_schedulingWithInvalidDoctorId_throwsBusinessException() {
        Scheduling schedulingRequest = new Scheduling(
                null,
                null,
                patientId,
                doctorScheduleId,
                schedulingDate
        );
        assertThrows(BusinessException.class, () -> {
            createScheduleAppointmentUseCaseImpl.createSchedulingAppointment(schedulingRequest);
        });
    }

    @Test
    void createSchedulingAppointment_schedulingWithInvalidPatientId_throwsBusinessException() {
        Scheduling schedulingRequest = new Scheduling(
                null,
                doctorId,
                null,
                doctorScheduleId,
                schedulingDate
        );
        assertThrows(BusinessException.class, () -> {
            createScheduleAppointmentUseCaseImpl.createSchedulingAppointment(schedulingRequest);
        });
    }

    @Test
    void createSchedulingAppointment_schedulingWithInvalidDoctorScheduleId_throwsBusinessException() {
        Scheduling schedulingRequest = new Scheduling(
                null,
                doctorId,
                patientId,
                null,
                schedulingDate
        );
        assertThrows(BusinessException.class, () -> {
            createScheduleAppointmentUseCaseImpl.createSchedulingAppointment(schedulingRequest);
        });
    }

    @Test
    void createSchedulingAppointment_schedulingWithInvalidScheduleDate_throwsBusinessException() {
        Scheduling schedulingRequest = new Scheduling(
                null,
                doctorId,
                patientId,
                doctorScheduleId,
                null
        );
        assertThrows(BusinessException.class, () -> {
            createScheduleAppointmentUseCaseImpl.createSchedulingAppointment(schedulingRequest);
        });
    }
}