package io.bgroup.calc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "404";// view name for 404 error (not exist now)
    }
}
