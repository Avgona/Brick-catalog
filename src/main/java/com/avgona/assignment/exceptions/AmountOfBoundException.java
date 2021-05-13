package com.avgona.assignment.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AmountOfBoundException extends RuntimeException{

    public AmountOfBoundException(String message){
        super(message);
    }
    public AmountOfBoundException(String message, Throwable cause){
        super(message, cause);
    }
    public AmountOfBoundException(Throwable cause){
        super(cause);
    }
}
