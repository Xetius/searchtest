package com.xetius.searchtest.exception;

public class NotEnoughArgumentsException extends Exception{
    public NotEnoughArgumentsException() {
        super("Not enough parameters.");
    }
}
