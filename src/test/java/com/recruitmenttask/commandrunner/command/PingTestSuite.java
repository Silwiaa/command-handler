package com.recruitmenttask.commandrunner.command;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class PingTestSuite {
    @Test
    public void testRunIfArgEqualsName() {
        //Given
        String arg = "PING";
        Ping ping = new Ping(arg);

        //When
        String result = ping.run();

        //Then
        assertTrue(result.equals("PONG"));
    }

    @Test
    public void testRunIfArgNotEqualsName() {
        //Given
        String arg = "NEXT";
        Ping ping = new Ping(arg);

        //When
        String result = ping.run();

        //Then
        assertTrue(result.equals("NEXT"));
    }

    @Test
    public void testGetDescription() {
        //Given
        String commandName = "PING";
        Ping ping = new Ping();

        //When
        String result = ping.getDescription(commandName);

        //Then
        assertTrue(result.equals("Prints pong"));
    }
}
