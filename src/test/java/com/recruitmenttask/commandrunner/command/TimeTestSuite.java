package com.recruitmenttask.commandrunner.command;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class TimeTestSuite {
    @Test
    public void testRunIfArgEqualsName() {
        //Given
        String arg = "TIME";
        Time time = new Time(arg);

        //When
        String result = time.run();

        //Then
        assertTrue(result.equals(LocalTime.now().toString()));
    }

    @Test
    public void testRunIfArgNotEqualsName() {
        //Given
        String arg = "NEXT";
        Time time = new Time(arg);

        //When
        String result = time.run();

        //Then
        assertTrue(result.equals("NEXT"));
    }

    @Test
    public void testGetDescription() {
        //Given
        String commandName = "TIME";
        Time time = new Time();

        //When
        String result = time.getDescription(commandName);

        //Then
        assertTrue(result.equals("Prints current time"));
    }
}
