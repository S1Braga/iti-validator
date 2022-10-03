package com.itidigital.validator.domain.validationstrategy.impl;

import com.itidigital.validator.application.web.requests.PasswordValidationRequest;
import com.itidigital.validator.application.web.requests.ValidatorType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidationStrategyTest {

    private final List<String> patterns = List.of(".*[0-9]+.*", ".*[a-z]+.*", ".*[!@#$%^&*()-+]+.*", ".*[A-Z]+.*", ".{9;}", "(?:(.)(?!.*\\1))*", "\\S*");

    private final PasswordValidationStrategy passwordValidationStrategy = new PasswordValidationStrategy(patterns);


    @Test
    public void verifyConditionTypePasswordTestReturnsTrue() {
        var type = ValidatorType.PASSWORD;
        assertTrue(passwordValidationStrategy.verityCondition(type));
    }

    @Test
    public void givenAnInputStringWhenItMeetsAllRequirementsReturnTrue() {

        //arrange
        var input = PasswordValidationRequest.builder().password("5gt6KCr*%").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertTrue(result);
    }

    @Test
    public void givenAnInputStringWhenItEndsWithAnumberShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("ab c123").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItDoesntcontainsAnumberShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("ab2c").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItDoesntContainsALowerCaseCharShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("ABCT4%U21").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItDoesnTContainsASpecialCharShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("ABC4f21").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItEndsWithAUpperCaseCharShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("abc4%21aBB").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItDoesnTContainsAUpperCaseCharShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("abc4%21").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenIsLowerThanTheSpecifiedShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("abCt4").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItEndsWithARepetitionShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("abc4%21aBB").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItStartsWithARepetitionShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("vvNnABC4%21").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItContainsARepetitionShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("abCt4%%u21").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItEndsWithAWhitespaceShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("abc4%21aBB  ").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItStartsWithAWhitespaceShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("vvNnABC4%21").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }

    @Test
    public void givenAnInputStringWhenItContainsAWhitespaceShouldReturnFalse() {

        //arrange
        var input = PasswordValidationRequest.builder().password("abC t4% %u21").build();

        //act
        var result = passwordValidationStrategy.isValid(input);

        //assert
        assertFalse(result);
    }


    public PasswordValidationRequest getPasswordValidationRequest() {
        return PasswordValidationRequest.builder()
                .password("teste")
                .build();
    }
}
