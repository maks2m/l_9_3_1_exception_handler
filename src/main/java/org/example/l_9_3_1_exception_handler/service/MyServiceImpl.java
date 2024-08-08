package org.example.l_9_3_1_exception_handler.service;

import com.github.javafaker.Faker;
import org.example.l_9_3_1_exception_handler.exception.MyFirstException;
import org.example.l_9_3_1_exception_handler.exception.MySecondException;
import org.example.l_9_3_1_exception_handler.model.DataModel;
import org.example.l_9_3_1_exception_handler.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public ResponseModel<DataModel> getRuntimeException(boolean isTrue) {
        if(!isTrue) throw new RuntimeException("RuntimeException");
        return ResponseModel.of(getData());
    }

    @Override
    public ResponseModel<DataModel> getMyException(int number) {
        return switch (number) {
            case 1 -> throw new MyFirstException("MyFirstException");
            case 2 -> throw new MySecondException("MySecondException");
            default -> ResponseModel.of(getData());
        };
    }

    @Override
    public ResponseModel<DataModel> getResponseStatusException(boolean isTrue) {
        if(!isTrue) throw new ResponseStatusException(HttpStatus.CONFLICT, "MyException");
        return ResponseModel.of(getData());
    }

    private DataModel getData() {
        Faker faker = new Faker();
        return DataModel.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .address(faker.address().fullAddress())
                .birthday(LocalDate.ofInstant(faker.date().birthday().toInstant(), ZoneId.systemDefault()))
                .build();
    }
}
