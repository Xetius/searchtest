package com.xetius.searchtest;

import com.xetius.searchtest.config.Config;
import com.xetius.searchtest.config.ConfigFactory;
import com.xetius.searchtest.exception.MissingDirectoryException;
import com.xetius.searchtest.exception.MissingFileNameException;
import com.xetius.searchtest.search.Search;
import com.xetius.searchtest.search.filter.NameMatchingFilter;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Config config = ConfigFactory.getConfig(args);
            Search search = new Search(config.getDirectory(), new NameMatchingFilter(config.getFileName()));
            List<String> results = search.find();

            for (String result : results) {
                System.out.println(result);
            }
        } catch (MissingFileNameException|MissingDirectoryException|IOException e) {
            displayUsage(e.getMessage());
        }
    }

    private static void displayUsage(String errorMessage) {
        if (!errorMessage.isEmpty()) {
            System.out.println(errorMessage);
        }
        System.out.println("usage: search -f <filename> <directory>");
    }
}
