package com.xetius.searchtest.config;

import com.xetius.searchtest.exception.MissingDirectoryException;
import com.xetius.searchtest.exception.MissingFileNameException;

public class ConfigFactory {

    private static final java.lang.String OPTION_PREFIX = "-";

    public static Config getConfig(final String[] args) throws MissingFileNameException, MissingDirectoryException {
        String fileName = "";
        String directory = "";

        int i = 0;
        int max_arg= args.length;

        while (i < max_arg) {
            String arg = args[i];
            if (arg.startsWith(OPTION_PREFIX)) {
                String option = arg.substring(1);
                switch (option) {
                    case "f":
                        i++;
                        fileName = args[i];
                        break;
                }
            } else {
                directory = arg;
            }
            i++;
        }

        if (fileName.isEmpty()) {
            throw new MissingFileNameException();
        }

        if (directory.isEmpty()) {
            throw new MissingDirectoryException();
        }

        return new Config(fileName, directory);
    }
}
