package com.xetius.searchtest.search;

import com.xetius.searchtest.search.filter.NameMatchingFilter;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    @Test
    public void findMethodReturnsListOfAllFiles() throws Exception {
        Search search = new Search("sample");
        final List<String> files = search.find();

        assertThat(files.size(), equalTo(5));
    }

    @Test
    public void searchWithNameMatchingFilterReturnsOnlyFilesMatching() throws Exception {
        Search search = new Search("sample", new NameMatchingFilter("file.txt"));
        final List<String> files = search.find();

        assertThat(files.size(), equalTo(3));
    }
}