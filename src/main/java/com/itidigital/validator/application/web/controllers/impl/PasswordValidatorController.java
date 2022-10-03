package com.itidigital.validator.application.web.controllers.impl;

import com.itidigital.validator.application.web.controllers.IPasswordValidatorController;
import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import com.itidigital.validator.domain.validator.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/validate")
@RequiredArgsConstructor
public class PasswordValidatorController implements IPasswordValidatorController {

    private final ValidatorService validatorService;

    @Override
    @PostMapping("/password")
    public Boolean isValid(@RequestBody PasswordValidationRequest passwordValidationRequest) {

        return validatorService.isValid(passwordValidationRequest);
    }

}
