package com.myproject.exceptions;

public class TestDataException extends RuntimeException {

    public TestDataException() {
        super();
    }

    public TestDataException(String message) {
        super(message);
    }

    public TestDataException(String message, String... params) {
        super(String.format(message, (Object[]) params));
    }
}
