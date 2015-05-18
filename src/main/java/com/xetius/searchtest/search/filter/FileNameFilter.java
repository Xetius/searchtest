package com.xetius.searchtest.search.filter;

import java.nio.file.Path;

public class FileNameFilter implements Filter {
    private String fileName;

    public FileNameFilter(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean filter(final Path path) {
        return path.getFileName().toString().equals(fileName);
    }
}
