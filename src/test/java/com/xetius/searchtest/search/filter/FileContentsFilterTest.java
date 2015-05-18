package com.xetius.searchtest.search.filter;

import org.junit.Test;

import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileContentsFilterTest {

    @Test
    public void missingFileReturnsFalseFromFilter() throws Exception {
        Filter filter = new FileContentsFilter("something");
        assertThat(filter.filter(Paths.get("this/path/does/not/exist/file.txt")), equalTo(false));
    }

    @Test
    public void filterReturnsFalseIfFileDoesNotContainText() throws Exception {
        Filter filter = new FileContentsFilter("missing");
        assertThat(filter.filter(Paths.get("sample/file.txt")), equalTo(false));
    }

    @Test
    public void filterReturnsTrueIfFileContainText() throws Exception {
        Filter filter = new FileContentsFilter("elephant");
        assertThat(filter.filter(Paths.get("sample/file.txt")), equalTo(true));
    }
}