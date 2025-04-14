package com.siigo.automation.exceptions;

public class MessageError extends AssertionError {

    public MessageError(String message, Throwable cause) {
        super(message, cause);
    }
}
