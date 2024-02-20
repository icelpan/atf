package com.myproject.assertions;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Boolean.TRUE;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.lang.System.lineSeparator;

@Slf4j
public class CustomAssertions {

    public static final String ASSERT_THAT = "Assert that ";
    public static final String ASSERTION_EXPECTED_ACTUAL_MESSAGE = "%s%4$s - [ EXPECTED]: %s%4$s - [ ACTUAL  ]: %s";
    private static Logger logger = LoggerFactory.getLogger(CustomAssertions.class);

    public static <T> void assertThat(final String message, final T actual, final Matcher<? super T> matcher) {

        final String fullMessage = ASSERT_THAT + message;
        final String logMessage = getAssertionExpectedActualMessage(fullMessage, valueOf(matcher), valueOf(actual));
        try {
            MatcherAssert.assertThat(fullMessage, actual, matcher);
            log.info(logMessage);
        } catch (AssertionError error) {
            log.error(logMessage);
            throw new AssertionError(error.getMessage());
        }
    }

    public static void assertTrue(final String message, final boolean condition) {
        final String fullMessage = ASSERT_THAT + message;
        final String logMessage = getAssertionExpectedActualMessage(fullMessage, TRUE, condition);
        try {
            Assertions.assertTrue(condition, fullMessage);
            log.info(logMessage);
        } catch (AssertionError error) {
            log.error(logMessage);
            throw new AssertionError(error.getMessage());
        }
    }

    public static void assertFalse(final String message, final boolean condition) {
        final String fullMessage = ASSERT_THAT + message;
        final String logMessage = getAssertionExpectedActualMessage(fullMessage, TRUE, condition);
        try {
            Assertions.assertFalse(condition, message);
            logger.info(logMessage);
        } catch (AssertionError error) {
            logger.error(logMessage);
            throw new AssertionError(error.getMessage());
        }
    }

    public static String getAssertionExpectedActualMessage(final String fullMessage, final String expected, final String actual){
        return format(ASSERTION_EXPECTED_ACTUAL_MESSAGE, fullMessage, expected, actual, lineSeparator());
    }

    public static <T> String getAssertionExpectedActualMessage(final String fullMessage, final T expected, final T actual) {
        return getAssertionExpectedActualMessage(fullMessage, valueOf(expected), valueOf(actual));
    }
}
