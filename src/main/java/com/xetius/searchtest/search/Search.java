package com.xetius.searchtest.search;

import com.xetius.searchtest.search.filter.Filter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {
    private String root;
    private List<Filter> filters;

    public Search(String root, Filter... filters) {
        this.root = root;
        this.filters = Arrays.asList(filters);
    }

    public List<String> find() throws IOException {
        List<String> results = new ArrayList<>();

        Files.walk(Paths.get(root)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                if (shouldAddFile(filePath)) {
                    results.add(filePath.toString());
                }
            }
        });

        return results;
    }

    private boolean shouldAddFile(Path filePath) {
        for(Filter filter : filters) {
            if (!filter.filter(filePath)) {
                return false;
            }
        }
        return true;
    }
}
