package org.example.l_9_3_1_exception_handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MySecondException extends RuntimeException {
    public MySecondException(String message) {
        super(message);
    }

    public MySecondException(String message, Throwable cause) {
        super(message, cause);
    }
}
