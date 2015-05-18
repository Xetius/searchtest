package com.xetius.searchtest.search;

import com.xetius.searchtest.search.filter.FileContentsFilter;
import com.xetius.searchtest.search.filter.FileNameFilter;
import com.xetius.searchtest.search.filter.RegexFileContentsFilter;
import com.xetius.searchtest.search.filter.RegexFileNameFilter;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    @Test
    public void findMethodReturnsListOfAllFiles() throws Exception {
        Search search = new Search("sample");
        final List<String> files = search.find();
        assertThat(files.size(), equalTo(7));
    }

    @Test
    public void searchWithNameMatchingFilterReturnsOnlyFilesMatching() throws Exception {
        Search search = new Search("sample");
        search.addFilter(new FileNameFilter("file.txt"));
        final List<String> files = search.find();
        assertThat(files.size(), equalTo(3));
    }

    @Test
    public void searchWithContentsMatchingFilterReturnsOnlyFilesWithMatchingContents() throws Exception {
        Search search = new Search("sample");
        search.addFilter(new FileContentsFilter("elephant"));
        final List<String> files = search.find();
        assertThat(files.size(), equalTo(2));
    }

    @Test
    public void searchWithRegexFileNameMatchingMatchesUsingRegex() throws Exception {
        Search search = new Search("sample");
        search.addFilter(new RegexFileNameFilter(".+\\.txt"));
        final List<String> files = search.find();
        assertThat(files.size(), equalTo(5));
    }

    @Test
    public void searchWithRegexContentMatchingMatchesUsingRegex() throws Exception {
        Search search = new Search("sample");
        search.addFilter(new RegexFileContentsFilter("some.+[1-9]"));
        final List<String> files = search.find();
        assertThat(files.size(), equalTo(2));
    }
}