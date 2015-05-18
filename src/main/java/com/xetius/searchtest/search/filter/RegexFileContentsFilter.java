package com.xetius.searchtest.search.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFileContentsFilter extends FileContentsFilter{
    public RegexFileContentsFilter(String regex) {
        super(regex);
    }

    @Override
    protected boolean itMatches(String line) {
        Pattern pattern = Pattern.compile(contents);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
