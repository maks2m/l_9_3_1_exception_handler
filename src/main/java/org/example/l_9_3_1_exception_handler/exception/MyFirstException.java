package org.example.l_9_3_1_exception_handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class MyFirstException extends RuntimeException {
    public MyFirstException(String message) {
        super(message);
    }

    public MyFirstException(String message, Throwable cause) {
        super(message, cause);
    }
}
