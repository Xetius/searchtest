package com.xetius.searchtest.search.filter;

import java.nio.file.Path;

public class NameMatchingFilter implements Filter {
    private String fileName;

    public NameMatchingFilter(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean filter(final Path path) {
        return path.getFileName().toString().equals(fileName);
    }
}
