package com.myproject.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomTestException extends RuntimeException {

    public CustomTestException() {
        super();
    }

    public CustomTestException(String message) {
        super(message);
        log.error("Exception occurred: {}", message);
    }

    public CustomTestException(String message, String... params) {
        super(String.format(message, (Object[]) params));
        log.error("Exception occurred: {}", (String.format(message, (Object[]) params)));
    }

    public CustomTestException(String message, Throwable cause) {
        super(message, cause);
    }

}
