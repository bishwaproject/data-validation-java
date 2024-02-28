
package com.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.exceptions.ValidationException;
import com.demo.models.User;
import com.demo.validators.InputValidator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.debug("Starting the application...");

        // Input validation
        String input = "test";
        try {
            InputValidator.validateString(input, 5, 20); // Adjusting to pass both min and max length
        } catch (ValidationException e) {
            logger.error("Invalid input: {}", e.getMessage());
        }

        // JSON to Object (Read from file)
        List<User> users = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        String jsonFilePath = "src/main/resources/user-data.json";

        try {
            // Read multiple user objects from the file
            users = mapper.readValue(new File(jsonFilePath), new TypeReference<List<User>>(){});

            // Validate and process each user object
            for (User user : users) {
                try {
                    validateUser(user);
                    logger.info("Valid User: ID - {}, Name - {}, Age - {}", user.getId(), user.getName(), user.getAge());
                    // Print validated user details
                    System.out.println("Valid User: ID - " + user.getId() + ", Name - " + user.getName() + ", Age - " + user.getAge());
                } catch (ValidationException e) {
                    logger.warn("Invalid user data: ID - {}, Name - {}, Age - {}. Error: {}", user.getId(), user.getName(), user.getAge(), e.getMessage());
                }
            }
        } catch (IOException e) {
            logger.error("Error processing JSON file: {}. Error: {}", jsonFilePath, e.getMessage());
        } catch (Exception e) { // Catch unexpected exceptions for robustness
            logger.error("Unexpected error: {}", e.getMessage());
        }

        logger.debug("Exiting the application...");
    }

    private static void validateUser(User user) throws ValidationException {
        InputValidator.validateString(user.getName(), 5, 20); // Validate name between 5 and 20 characters
        InputValidator.validateInteger(user.getAge(), 25, 120); // Validate age between 18 and 120
    }
}
