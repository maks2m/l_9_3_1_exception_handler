package org.example.l_9_3_1_exception_handler.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.l_9_3_1_exception_handler.model.ErrorModel;
import org.example.l_9_3_1_exception_handler.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = { MyFirstException.class })
    public ResponseEntity<ResponseModel<ErrorModel>> handleMyFirstException() {
        ErrorModel errorModel = ErrorModel.builder()
                .code("error.MyFirstException")
                .message("MyFirstException")
                .build();
        log.error(errorModel.toString());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseModel.of(errorModel));
    }

    @ExceptionHandler(value = { MySecondException.class })
    public ResponseEntity<ResponseModel<ErrorModel>> handleMySecondException() {
        ErrorModel errorModel = ErrorModel.builder()
                .code("error.MySecondException")
                .message("MySecondException")
                .build();
        log.error(errorModel.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseModel.of(errorModel));
    }

    @ExceptionHandler(value = { ResponseStatusException.class })
    public ResponseEntity<ResponseModel<ErrorModel>> handleResponseStatusException() {
        ErrorModel errorModel = ErrorModel.builder()
                .code("error.ResponseStatusException")
                .message("ResponseStatusException")
                .build();
        log.error(errorModel.toString());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseModel.of(errorModel));
    }

    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<ResponseModel<ErrorModel>> handleRuntimeException() {
        ErrorModel errorModel = ErrorModel.builder()
                .code("error.RuntimeException")
                .message("RuntimeException")
                .build();
        log.error(errorModel.toString());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseModel.of(errorModel));
    }

}
