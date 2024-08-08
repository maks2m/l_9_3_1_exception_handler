package org.example.l_9_3_1_exception_handler.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorModel {
    private String code;
    private String message;
}
