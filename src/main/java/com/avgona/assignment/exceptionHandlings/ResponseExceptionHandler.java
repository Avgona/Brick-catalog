package com.avgona.assignment.exceptionHandlings;

import com.avgona.assignment.exceptions.AmountOfBoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(AmountOfBoundException.class)
    public ModelAndView handlerAmountOfBoundException(AmountOfBoundException ex){
        log.error(">>>>>>>>>> Amount of bound exception.");
        log.error(ex.getMessage(), ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("service/amount-of-bound-exception");

        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAnyException(Exception ex) {
        log.error(">>>>>>>>>> Exception");
        log.error(ex.getMessage(), ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("service/something-went-wrong");

        return modelAndView;
    }
}
