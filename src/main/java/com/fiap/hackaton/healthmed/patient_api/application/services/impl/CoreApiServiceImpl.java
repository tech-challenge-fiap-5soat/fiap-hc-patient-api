package com.fiap.hackaton.healthmed.patient_api.application.services.impl;

import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.CoreApiGateway;
import com.fiap.hackaton.healthmed.patient_api.application.services.CoreApiService;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoreApiServiceImpl implements CoreApiService {

    @Autowired
    private final CoreApiGateway coreApiGateway;

    @Override
    public List<Doctor> listDoctors(Boolean includeWithoutSlots, String specialty) {
        return coreApiGateway.listDoctors(includeWithoutSlots, specialty);
    }
}