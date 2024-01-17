package com.myproject.assertions;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        }catch (AssertionError error){
            log.error(logMessage);
            throw new AssertionError(error.getMessage());
        }
    }
}
