package com.xetius.searchtest.config;

import com.xetius.searchtest.exception.DisplayUsageException;
import com.xetius.searchtest.exception.MissingDirectoryException;
import com.xetius.searchtest.exception.MissingFileNameException;

public class ConfigFactory {

    private static final java.lang.String OPTION_PREFIX = "-";

    public static Config getConfig(final String[] args)
        throws MissingFileNameException, MissingDirectoryException, DisplayUsageException {

        Config config = new Config();

        int i = 0;
        int max_arg= args.length;

        while (i < max_arg) {
            String arg = args[i];
            if (arg.startsWith(OPTION_PREFIX)) {
                String option = arg.substring(1);
                switch (option) {

                    case "f":
                        i++;
                        config.setFileName(args[i]);
                        break;

                    case "p":
                        i++;
                        config.setParameter(args[i]);
                        break;

                    case "x":
                        config.shoulUseRegex(true);
                        break;

                    case "h":
                        throw new DisplayUsageException();
                }
            } else {
                config.setDirectory(arg);
            }
            i++;
        }

        if (config.getFileName() == null || config.getFileName().isEmpty()) {
            throw new MissingFileNameException();
        }

        if (config.getDirectory() == null || config.getDirectory().isEmpty()) {
            throw new MissingDirectoryException();
        }

        return config;
    }
}
