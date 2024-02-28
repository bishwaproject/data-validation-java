package com.demo.validators;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.demo.exceptions.ValidationException;

public class InputValidator {
	

	public static void validateString(@NotNull String input, @Min(5) @Max(20) int minLength, @Max(20) int maxLength) 
		      throws ValidationException {
		    
		    if (input == null) {
		        throw new ValidationException("Input cannot be null");
		    }
		    
		    int inputLength = input.length();
		    if (inputLength < minLength || inputLength > maxLength) {  
		        throw new ValidationException("Input must be between " + minLength + " and " + maxLength + " characters");
		    }
		}
	public static void validateInteger(int input, int minValue, int maxValue) throws ValidationException {
	    if (input < minValue || input > maxValue) {
	        throw new ValidationException("Input must be between " + minValue + " and " + maxValue);
	    }
	}



}
