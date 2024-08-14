package com.myproject.utils;

import com.myproject.exceptions.CustomTestException;

import java.io.IOException;

import static java.nio.file.Files.readString;
import static java.nio.file.Paths.get;

public class CommonUtils {

    public static final String TEMPLATES_PATH = "src/test/resources/requests";

    public static String readRequestTemplateAsString(final String path) {
        final String fullPath = TEMPLATES_PATH + path;

        try {
            return readString(get(fullPath));
        } catch (IOException e) {
            throw new CustomTestException("Could not read file: " + fullPath, e);
        }
    }
}
