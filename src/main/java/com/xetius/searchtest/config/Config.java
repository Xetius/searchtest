package com.xetius.searchtest.config;

public class Config {

    private String fileName;
    private String directory;
    private String parameter;
    private boolean shouldUseRegex;

    Config() {
        shouldUseRegex = false;
    }

    void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    void setDirectory(final String directory) {
        this.directory = directory;
    }

    void setParameter(final String parameter) {
        this.parameter = parameter;
    }

    void shoulUseRegex(boolean shouldUseRegex) {
        this.shouldUseRegex = shouldUseRegex;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDirectory() {
        return directory;
    }

    public String getParameter() {
        return parameter;
    }

    public boolean shouldUseRegex() {
        return shouldUseRegex;
    }
}
