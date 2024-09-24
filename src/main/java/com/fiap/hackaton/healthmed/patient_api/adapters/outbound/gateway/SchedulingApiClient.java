package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.gateway;

import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorSchedules;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.AvailableDoctorSchedulesRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreateSchedulingRequestDto;
import com.fiap.hackaton.healthmed.patient_api.adapters.outbound.dto.CreatedAppointment;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.SchedulingApiGateway;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Component
@FeignClient(value = "scheduling-api", url = "${feign.client.config.scheduling-api.service.url}")
public interface SchedulingApiClient extends SchedulingApiGateway {
    @RequestMapping(method = RequestMethod.POST, value = "/schedules/appointment")
    CreatedAppointment createSchedulingAppointment(@RequestBody CreateSchedulingRequestDto createRequestDto);

    @RequestMapping(method = RequestMethod.GET, value = "/schedules/available/{doctorId}")
    List<AvailableDoctorSchedules> availableDoctorSchedules(@PathVariable("doctorId") UUID doctorId,
                                                            @RequestBody AvailableDoctorSchedulesRequestDto requestDto);
}