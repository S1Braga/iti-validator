package com.itidigital.validator.application.web.controllers.impl;

import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import com.itidigital.validator.domain.validator.ValidatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PasswordValidatorControllerTest {

    @InjectMocks
    private PasswordValidatorController passwordValidatorController;

    @Mock
    private ValidatorService validatorService;

    @Test
    void passwordValidation_true() {

        PasswordValidationRequest passwordValidationRequest = Mockito.mock(PasswordValidationRequest.class);

        when(validatorService.isValid(passwordValidationRequest)).thenReturn(true);

        var response = passwordValidatorController.isValid(passwordValidationRequest);

        assertThat(response).isEqualTo(true);
    }

    @Test
    void passwordValidation_false() {

        PasswordValidationRequest passwordValidationRequest = Mockito.mock(PasswordValidationRequest.class);

        when(validatorService.isValid(passwordValidationRequest)).thenReturn(false);

        var response = passwordValidatorController.isValid(passwordValidationRequest);

        assertThat(response).isEqualTo(false);
    }
}
