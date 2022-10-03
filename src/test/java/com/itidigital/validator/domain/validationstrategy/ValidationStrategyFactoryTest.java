package com.itidigital.validator.domain.validationstrategy;

import com.itidigital.validator.application.web.requests.ValidatorType;
import com.itidigital.validator.domain.validationstrategy.impl.PasswordValidationStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidationStrategyFactoryTest {

    private final List<String> patterns = List.of(".*[0-9]+.*", ".*[a-z]+.*", ".*[!@#$%^&*()-+]+.*", ".*[A-Z]+.*", ".{9;}", "(?:(.)(?!.*\\1))*", "\\S*");

    private final PasswordValidationStrategy passwordValidationStrategy = new PasswordValidationStrategy(patterns);


    private final ValidationStrategyFactory validationStrategyFactory = new ValidationStrategyFactory(List.of(passwordValidationStrategy));

    @Test
    void getValidationStrategyFactoryTypePassword() {

        assertTrue(validationStrategyFactory.getValidatorStrategy(ValidatorType.PASSWORD) instanceof PasswordValidationStrategy);
    }
}
