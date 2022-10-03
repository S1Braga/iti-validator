package com.itidigital.validator.domain.validator;

import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import com.itidigital.validator.application.web.requests.ValidatorType;
import com.itidigital.validator.domain.validationstrategy.ValidationStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidatorService {

    private final ValidationStrategyFactory verifyValidatorStrategyFactory;

    public Boolean isValid(PasswordValidationRequest password) {
        return verifyValidatorStrategyFactory.getValidatorStrategy(ValidatorType.PASSWORD).isValid(password);
    }
}
