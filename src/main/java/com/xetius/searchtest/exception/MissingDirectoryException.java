package com.xetius.searchtest.exception;

public class MissingDirectoryException extends Exception{

    public MissingDirectoryException() {
        super("No directory specified on the command line.");
    }
}
