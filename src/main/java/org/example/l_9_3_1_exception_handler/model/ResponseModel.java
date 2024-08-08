package org.example.l_9_3_1_exception_handler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<D> {
    private ZonedDateTime createDate = ZonedDateTime.now();
    private D data;
    private ErrorModel error;

    private ResponseModel(D data) {
        this.data = data;
    }
    private ResponseModel(ErrorModel error) {
        this.error = error;
    }

    public static <D> ResponseModel<D> of(D data) {
        return new ResponseModel<>(data);
    }

    public static <D> ResponseModel<D> of(ErrorModel error) {
        return new ResponseModel<>(error);
    }
}
