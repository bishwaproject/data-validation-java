package com.demo.validators;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.demo.exceptions.ValidationException;

public class InputValidatorTest {

    @Test
    void testValidateString_NullInput() {
        ValidationException exception = assertThrows(ValidationException.class, () -> InputValidator.validateString(null, 5, 20));
        assertEquals("Input cannot be null", exception.getMessage());
    }

    @Test
    void testValidateString_TooShortInput() {
        ValidationException exception = assertThrows(ValidationException.class, () -> InputValidator.validateString("short", 10, 20));
        assertEquals("Input must be between 10 and 20 characters", exception.getMessage());
    }

    @Test
    void testValidateString_TooLongInput() {
        ValidationException exception = assertThrows(ValidationException.class, () -> InputValidator.validateString("thisInputIsTooLong", 5, 10));
        assertEquals("Input must be between 5 and 10 characters", exception.getMessage());
    }

    @Test
    void testValidateInteger_OutOfRangeInput() {
        ValidationException exception = assertThrows(ValidationException.class, () -> InputValidator.validateInteger(15, 1, 10));
        assertEquals("Input must be between 1 and 10", exception.getMessage());
    }

}
