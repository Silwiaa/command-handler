package com.recruitmenttask.commandrunner.command;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class VersionTestSuite {
    @Test
    public void testRunIfArgEqualsName() {
        //Given
        String arg = "VERSION";
        Version version = new Version(arg);

        //When
        String result = version.run();

        //Then
        assertTrue(result.equals("1.0"));
    }

    @Test
    public void testRunIfArgNotEqualsName() {
        //Given
        String arg = "NEXT";
        Version version = new Version(arg);

        //When
        String result = version.run();

        //Then
        assertTrue(result.equals("NEXT"));
    }

    @Test
    public void testGetDescription() {
        //Given
        String commandName = "VERSION";
        Version version = new Version();

        //When
        String result = version.getDescription(commandName);

        //Then
        assertTrue(result.equals("Prints current version"));
    }
}