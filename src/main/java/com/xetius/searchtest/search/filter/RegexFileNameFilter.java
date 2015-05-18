package com.xetius.searchtest.search.filter;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFileNameFilter implements Filter {

    private String regex;

    public RegexFileNameFilter(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean filter(Path path) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path.getFileName().toString());
        return matcher.find();
    }
}
