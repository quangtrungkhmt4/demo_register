package com.demoregister.demo_register.exception;

import com.demoregister.demo_register.constant.ResponseCode;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomResponseException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(HttpServletRequest request) {
        System.out.println(request);
        return new ResponseEntity<>(new com.demoregister.demo_register
                .response.ResponseEntity(ResponseCode.WRONG_DATA_FORMAT).toString(), HttpStatus.NOT_FOUND);
    }

}
