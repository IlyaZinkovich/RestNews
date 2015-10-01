package com.epam.newsmanagement.model.dao.exception;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
