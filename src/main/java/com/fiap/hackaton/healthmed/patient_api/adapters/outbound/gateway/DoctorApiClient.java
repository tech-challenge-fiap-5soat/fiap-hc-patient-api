package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.gateway;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorSchedules;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorSchedulesRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.DoctorApiGateway;
import com.fiap.hackaton.healthmed.patient_api.domain.model.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Component
@FeignClient(value = "doctor-api", url = "${feign.client.config.doctor-api.service.url}")
public interface DoctorApiClient extends DoctorApiGateway {

    @RequestMapping(method = RequestMethod.GET, value = "/doctors")
    public List<AvailableDoctorsDto> listDoctors();
}