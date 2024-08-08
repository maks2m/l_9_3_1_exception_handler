package org.example.l_9_3_1_exception_handler.service;

import org.example.l_9_3_1_exception_handler.model.DataModel;
import org.example.l_9_3_1_exception_handler.model.ResponseModel;

public interface MyService {
    ResponseModel<DataModel> getRuntimeException(boolean isTrue);
    ResponseModel<DataModel> getMyException(int number);
    ResponseModel<DataModel> getResponseStatusException(boolean isTrue);
}
