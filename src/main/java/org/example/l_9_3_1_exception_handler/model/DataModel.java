package org.example.l_9_3_1_exception_handler.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DataModel {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private LocalDate birthday;
}
