package com.xetius.searchtest.config;

public class Config {

    private String fileName;
    private String directory;

    Config(String fileName, String directory) {
        this.fileName = fileName;
        this.directory = directory;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDirectory() {
        return directory;
    }
}
