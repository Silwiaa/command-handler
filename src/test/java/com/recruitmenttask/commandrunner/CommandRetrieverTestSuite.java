package com.recruitmenttask.commandrunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.LocalTime;

import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CommandRetrieverTestSuite {
    @InjectMocks
    private CommandRetriever commandRetriever;

    @Test
    public void shouldGetVersion() {
        //Given
        String expectedVal = "1.0";

        //When
        String resultVal = commandRetriever.getVersion();

        //Then
        assertEquals(expectedVal, resultVal);
    }

    @Test
    public void shouldGetPing() {
        //Given
        String expectedVal = "PONG";

        //When
        String resultVal = commandRetriever.getPing();

        //Then
        assertEquals(expectedVal, resultVal);
    }

    @Test
    public void shouldGetTime() {
        //Given
        LocalTime expectedVal = LocalTime.now();

        //When
        LocalTime resultVal = LocalTime.parse(commandRetriever.getTime());

        //Then
        assertEquals(expectedVal.getHour(), resultVal.getHour());
        assertEquals(expectedVal.getMinute(), resultVal.getMinute());
        assertEquals(expectedVal.getSecond(), resultVal.getSecond());
    }

    @Test
    public void shouldGetArg() {
        //Given
        String arg = "NEXT";

        //When
        String resultVal = commandRetriever.getArg(arg);

        //Then
        assertEquals(arg, resultVal);
    }
}
