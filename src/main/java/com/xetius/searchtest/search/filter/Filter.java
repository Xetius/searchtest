package com.xetius.searchtest.search.filter;

import java.nio.file.Path;

public interface Filter {
    boolean filter(final Path path);
}
