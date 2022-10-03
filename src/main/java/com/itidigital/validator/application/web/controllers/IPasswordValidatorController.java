package com.itidigital.validator.application.web.controllers;

import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Password Validator")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "password successfully analyzed!")
})
public interface IPasswordValidatorController {

    Boolean isValid(PasswordValidationRequest passwordValidationRequest);
}
