package com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase;

import com.fiap.hackaton.healthmed.patient_api.application.ports.input.useCase.impl.LoginPatientUseCaseImpl;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.AuthApiGateway;
import com.fiap.hackaton.healthmed.patient_api.application.ports.output.gateway.dto.LoginRequestDto;
import com.fiap.hackaton.healthmed.patient_api.application.services.AuthApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class LoginPatientUseCaseTest {

    @Mock
    private AuthApiGateway authApiGateway;
    @Mock
    private AuthApiService authApiService;


    @InjectMocks
    private LoginPatientUseCaseImpl loginPatientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loginAndGetAuthToken_validCredentials_returnsAuthToken() {
        String email = "test@example.com";
        String password = "password";
        String expectedToken = "authToken";
        LoginRequestDto loginRequestDto = new LoginRequestDto(email, password);
        when(authApiService.login(loginRequestDto)).thenReturn(expectedToken);

        String actualToken = loginPatientUseCase.loginAndGetAuthToken(email, password);

        assertEquals(expectedToken, actualToken);
    }

    @Test
    void loginAndGetAuthToken_invalidCredentials_returnsNull() {
        String email = "invalid@example.com";
        String password = "wrongPassword";
        LoginRequestDto loginRequestDto = new LoginRequestDto(email, password);
        when(authApiService.login(loginRequestDto)).thenReturn(null);

        String actualToken = loginPatientUseCase.loginAndGetAuthToken(email, password);

        assertEquals(null, actualToken);
    }

    @Test
    void loginAndGetAuthToken_emptyEmail_returnsNull() {
        String email = "";
        String password = "password";
        LoginRequestDto loginRequestDto = new LoginRequestDto(email, password);
        when(authApiService.login(loginRequestDto)).thenReturn(null);

        String actualToken = loginPatientUseCase.loginAndGetAuthToken(email, password);

        assertEquals(null, actualToken);
    }

    @Test
    void loginAndGetAuthToken_emptyPassword_returnsNull() {
        String email = "test@example.com";
        String password = "";
        LoginRequestDto loginRequestDto = new LoginRequestDto(email, password);
        when(authApiService.login(loginRequestDto)).thenReturn(null);

        String actualToken = loginPatientUseCase.loginAndGetAuthToken(email, password);

        assertEquals(null, actualToken);
    }

    @Test
    void loginAndGetAuthToken_nullEmail_returnsNull() {
        String email = null;
        String password = "password";
        LoginRequestDto loginRequestDto = new LoginRequestDto(email, password);
        when(authApiService.login(loginRequestDto)).thenReturn(null);

        String actualToken = loginPatientUseCase.loginAndGetAuthToken(email, password);

        assertEquals(null, actualToken);
    }

    @Test
    void loginAndGetAuthToken_nullPassword_returnsNull() {
        String email = "test@example.com";
        String password = null;
        LoginRequestDto loginRequestDto = new LoginRequestDto(email, password);
        when(authApiService.login(loginRequestDto)).thenReturn(null);

        String actualToken = loginPatientUseCase.loginAndGetAuthToken(email, password);

        assertEquals(null, actualToken);
    }
}