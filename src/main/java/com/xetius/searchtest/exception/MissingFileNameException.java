package com.xetius.searchtest.exception;

public class MissingFileNameException extends Exception {
    public MissingFileNameException() {
        super("No file name specified on the command line.");
    }
}
