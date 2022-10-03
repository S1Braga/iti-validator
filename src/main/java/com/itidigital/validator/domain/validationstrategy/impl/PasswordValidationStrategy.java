package com.itidigital.validator.domain.validationstrategy.impl;

import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import com.itidigital.validator.application.web.requests.ValidatorType;
import com.itidigital.validator.domain.validationstrategy.IValidationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PasswordValidationStrategy implements IValidationStrategy {

    @Value("${validation.password.patterns}")
    private final List<String> patterns;

    @Override
    public boolean verityCondition(ValidatorType type) {
        return ValidatorType.PASSWORD == type;
    }

    @Override
    public boolean isValid(PasswordValidationRequest passwordValidationRequest) {

        var password = passwordValidationRequest.getPassword();
        var fixedPatterns = patterns.stream().map(it -> it.replace(';', ',')).collect(Collectors.toList());

        AtomicBoolean isValid = new AtomicBoolean(true);

        fixedPatterns.forEach(p -> {
            if (!password.matches(p)) {
                isValid.set(false);
            }
        });
        return isValid.get();
    }

}
