package com.jobinterviewer.util;

/**
 * Utility class for validating user inputs.
 * Provides static helper methods to validate common fields
 * such as email, names, etc.
 */
public class InputValidator {

    /**
     * Validates if the given string is a valid email address.
     * 
     * @param email the email address to validate
     * @return true if the email format is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        // Regex Explanation:
        // ^                -> start of string
        // [A-Za-z0-9+_.-]+ -> one or more valid characters before @
        // @                -> mandatory '@' symbol
        // (.+)             -> one or more characters for the domain (e.g., gmail.com)
        // $                -> end of string
        if (email == null || email.trim().isEmpty()) {
            return false; // Reject null or empty strings
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
