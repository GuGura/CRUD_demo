package com.example.testddd.demo.controller;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ExpiredJwtException.class)
    public Map<String, String> handleException(ExpiredJwtException e){
        Map<String,String> map = new HashMap<>();
        map.put("errMsg",e.getMessage());
        return map;
    }

    @ExceptionHandler(value = Exception.class)
    public Map<String, String> handleException(Exception e){
        Map<String,String> map = new HashMap<>();
        map.put("errMsg",e.getMessage());
        return map;
    }
}
