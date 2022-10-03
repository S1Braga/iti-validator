package com.itidigital.validator.domain.validationstrategy;

import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import com.itidigital.validator.application.web.requests.ValidatorType;

public interface IValidationStrategy {

    boolean verityCondition(ValidatorType validatorType);

    boolean isValid(PasswordValidationRequest passwordValidationRequest);

}
