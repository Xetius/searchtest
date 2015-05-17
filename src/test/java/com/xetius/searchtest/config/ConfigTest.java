package com.xetius.searchtest.config;

import com.xetius.searchtest.exception.MissingDirectoryException;
import com.xetius.searchtest.exception.MissingFileNameException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfigTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final static String expectedDirectory = "directory";
    private final static String expectedFileName = "file.xml";

    @Test
    public void configFactoryWillReturnConfigWithCorrectlySetFileNameAndDirectory() throws Exception {
        final String[] args = {"-f", expectedFileName, expectedDirectory};

        Config config = ConfigFactory.getConfig(args);

        assertThat(config, is(notNullValue()));
        assertThat(config.getDirectory(), equalTo(expectedDirectory));
        assertThat(config.getFileName(), equalTo(expectedFileName));
    }

    @Test
    public void configFactoryThrowsExceptionWithMissingFilename() throws Exception {
        thrown.expect(MissingFileNameException.class);
        final String[] args = {expectedDirectory};
        ConfigFactory.getConfig(args);
    }

    @Test
    public void configFactoryThrowExceptionWithMissingDirectory() throws Exception {
        thrown.expect(MissingDirectoryException.class);
        final String[] args = {"-f", expectedFileName};
        ConfigFactory.getConfig(args);
    }
}