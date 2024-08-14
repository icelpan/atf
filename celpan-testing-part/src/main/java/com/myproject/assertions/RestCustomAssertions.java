package com.myproject.assertions;

import org.hamcrest.MatcherAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;

public class RestCustomAssertions {

    public static final String MESSAGE_EXPECTED_ACTUAL = "%s%4$s - [ EXPECTED]: %s%4$s - [ ACTUAL  ]: %s";

    private static final Logger logger = LoggerFactory.getLogger(RestCustomAssertions.class);

    public static void assertThatStatusCodeIs(ResponseEntity<String> actual, HttpStatus expectedCode){
        String fullMessage = format("Assert that status code is %d %s", expectedCode.value(), expectedCode.getReasonPhrase());
        String logMessage = format(MESSAGE_EXPECTED_ACTUAL, fullMessage, System.lineSeparator(), expectedCode.value(), System.lineSeparator(), actual.getStatusCodeValue());
        try{
            MatcherAssert.assertThat(fullMessage, actual.getStatusCode(), is(expectedCode));
            logger.info(logMessage);
        } catch (AssertionError error){
            logger.error(logMessage);
            logger.error(actual.getBody());
            throw new AssertionError(error.getMessage());
        }
    }
}
