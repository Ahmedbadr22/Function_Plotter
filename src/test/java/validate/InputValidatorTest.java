package validate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void isValidEquation() {
        String equation = "x^2";
        boolean expIsValidEquation = InputValidator.isValidEquation(equation);
        assertTrue(expIsValidEquation);
    }

    @Test
    void isValidMaxAndMinValue() {
        String xMax = "5";
        String xMin = "2";
        boolean expIsValidMaxMin = InputValidator.isValidMaxAndMinValue(xMax, xMin);

        assertTrue(expIsValidMaxMin);
    }

    @Test
    void isAllInputValid() {
        String equation = "x^2";
        String xMax = "5";
        String xMin = "2";

        boolean isValidInput = InputValidator.isAllInputValid(equation, xMax, xMin);

        assertTrue(isValidInput);
    }
}