package com.itidigital.validator.domain.validator;

import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import com.itidigital.validator.domain.validationstrategy.ValidationStrategyFactory;
import com.itidigital.validator.domain.validationstrategy.impl.PasswordValidationStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ValidatorServiceTest {

    private final PasswordValidationStrategy passwordValidationStrategy = new PasswordValidationStrategy(List.of());


    private final ValidationStrategyFactory validationStrategyFactory = new ValidationStrategyFactory(List.of(passwordValidationStrategy));


    ValidatorService validatorService = spy(new ValidatorService(validationStrategyFactory));

    @Test
    public void isValidTest() {
        var passwordValidationRequest = getPasswordValidationRequest();

        validatorService.isValid(passwordValidationRequest);

        verify(validatorService, times(1)).isValid(passwordValidationRequest);
    }

    public PasswordValidationRequest getPasswordValidationRequest() {
        return PasswordValidationRequest.builder()
                .password("teste")
                .build();
    }
}
