package com.xetius.searchtest.search.filter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileContentsFilter implements Filter {
    protected String contents;

    public FileContentsFilter(final String contents) {
        this.contents = contents;
    }

    @Override
    public boolean filter(Path path) {
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (itMatches(line)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    protected boolean itMatches(String line) {
        return line.contains(contents);
    }
}
