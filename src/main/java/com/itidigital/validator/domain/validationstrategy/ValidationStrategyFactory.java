package com.itidigital.validator.domain.validationstrategy;

import com.itidigital.validator.application.web.requests.ValidatorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ValidationStrategyFactory {

    private final List<IValidationStrategy> validationStrategies;

    public IValidationStrategy getValidatorStrategy(ValidatorType validatorType) {
        return validationStrategies.stream()
                .filter(strategy -> strategy.verityCondition(validatorType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Implemented Validation" + validatorType));
    }

}
