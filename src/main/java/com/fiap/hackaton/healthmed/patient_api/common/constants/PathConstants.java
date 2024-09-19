package com.fiap.hackaton.healthmed.patient_api.common.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathConstants {

    public static final String PATIENTS = "/patients";
    public static final String DOCTORS = "/doctors";
    public static final String SCHEDULE_APPOINTMENT = "/patients/{id}/schedule-appointment";
}