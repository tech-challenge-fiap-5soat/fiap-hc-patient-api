package com.fiap.hackaton.healthmed.patient_api.adapters.outbound.gateway;

import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.AuthApiGateway;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.CreatePatientCredentialsDto;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.LoginRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Component
@FeignClient(value = "auth-api", url = "${feign.client.config.auth-api.service.url}")
public interface AuthApiClient extends AuthApiGateway {
    @RequestMapping(method = RequestMethod.POST, value = "/credentials")
    Boolean createCredentials(CreatePatientCredentialsDto createPatientCredentialsDto);

    @RequestMapping(method = RequestMethod.POST, value = "/authorization")
    String login(@RequestBody LoginRequestDto loginRequestDto);
}