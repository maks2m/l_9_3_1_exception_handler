package org.example.l_9_3_1_exception_handler.controller;

import lombok.RequiredArgsConstructor;
import org.example.l_9_3_1_exception_handler.model.DataModel;
import org.example.l_9_3_1_exception_handler.model.ResponseModel;
import org.example.l_9_3_1_exception_handler.service.MyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyController {

    private final MyService myService;

    @GetMapping("/get-runtime-exception")
    public ResponseEntity<ResponseModel<DataModel>> getRuntimeException(@RequestParam boolean isTrue) {
        return ResponseEntity.ok(myService.getRuntimeException(isTrue));
    }

    @GetMapping("/get-my-exception")
    public ResponseEntity<ResponseModel<DataModel>> getMyException(@RequestParam int number) {
        return ResponseEntity.ok(myService.getMyException(number));
    }

    @GetMapping("/get-response-status-exception")
    public ResponseEntity<ResponseModel<DataModel>> getResponseStatusException(@RequestParam boolean isTrue) {
        return ResponseEntity.ok(myService.getResponseStatusException(isTrue));
    }
}
