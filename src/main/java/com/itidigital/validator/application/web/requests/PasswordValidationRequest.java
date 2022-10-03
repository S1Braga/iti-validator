package com.itidigital.validator.application.web.requests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PasswordValidationRequest {

    private String password;
}
