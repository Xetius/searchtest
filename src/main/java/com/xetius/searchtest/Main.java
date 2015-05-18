package com.xetius.searchtest;

import com.xetius.searchtest.config.Config;
import com.xetius.searchtest.config.ConfigFactory;
import com.xetius.searchtest.exception.DisplayUsageException;
import com.xetius.searchtest.exception.MissingDirectoryException;
import com.xetius.searchtest.exception.MissingFileNameException;
import com.xetius.searchtest.exception.NotEnoughArgumentsException;
import com.xetius.searchtest.search.Search;
import com.xetius.searchtest.search.filter.FileContentsFilter;
import com.xetius.searchtest.search.filter.FileNameFilter;
import com.xetius.searchtest.search.filter.Filter;
import com.xetius.searchtest.search.filter.RegexFileContentsFilter;
import com.xetius.searchtest.search.filter.RegexFileNameFilter;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Config config = ConfigFactory.getConfig(args);
            Search search = new Search(config.getDirectory());

            boolean useRegex = config.shouldUseRegex();
            search.addFilter(getFileNameFilter(config));

            if (config.getParameter() != null) {
                search.addFilter(getFileContentFilter(config));
            }

            List<String> results = search.find();

            for (String result : results) {
                System.out.println(result);
            }
        } catch (MissingFileNameException | MissingDirectoryException | IOException |  NotEnoughArgumentsException | DisplayUsageException e) {
            displayUsage(e.getMessage());
        }
    }

    private static FileContentsFilter getFileContentFilter(Config config) {
        if (config.shouldUseRegex()) {
            return new RegexFileContentsFilter(config.getParameter());
        }
        return new FileContentsFilter(config.getParameter());
    }

    private static Filter getFileNameFilter(Config config) {
        if (config.shouldUseRegex()) {
            return new RegexFileNameFilter(config.getFileName());
        }
        return new FileNameFilter(config.getFileName());
    }

    private static void displayUsage(String errorMessage) {
        if (!errorMessage.isEmpty()) {
            System.out.println(errorMessage);
        }
        System.out.println("usage: search [-x] -f <filename> [-p <text>] <directory>");
        System.out.println("-f <fileName>   Name of the file to search for. If regex compatibility is enabled, then this is the pattern to match against.");
        System.out.println("<directory>     Path to the root directory to start the search in.");
        System.out.println("Optional");
        System.out.println("-x              Enable regex compatibiliy. Changes the -f and -p options to be regular expressions.");
        System.out.println("-p <text>       Match text content. Matching files must contain this text. If regex compatibility is enabled, then this is the pattern to match against.");
    }
}
