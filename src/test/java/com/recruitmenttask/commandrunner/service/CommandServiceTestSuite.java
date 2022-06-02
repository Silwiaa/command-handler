package com.recruitmenttask.commandrunner.service;

import com.recruitmenttask.commandrunner.exception.EmptyInputException;
import com.recruitmenttask.commandrunner.factory.CommandFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommandServiceTestSuite {
    @InjectMocks
    private CommandService commandService;

    @Mock
    private CommandFactory commandFactory;

    @Test
    public void testHandleCommandForPing() throws EmptyInputException {
        //Given
        String arg = "ping";
        when(commandFactory.handleCommand(arg)).thenReturn("PONG");

        //When
        String result = commandService.handleCommand(arg);

        //Then
        assertTrue(result.equals("PONG"));
    }

    @Test
    public void testHandleCommandForPingWithArg() throws EmptyInputException {
        //Given
        String arg = "ping next";
        when(commandFactory.handleCommand(arg)).thenReturn("NEXT");

        //When
        String result = commandService.handleCommand(arg);

        //Then
        assertTrue(result.equals("NEXT"));
    }

    @Test
    public void testHandleCommandForVersion() throws EmptyInputException {
        //Given
        String arg = "version";
        when(commandFactory.handleCommand(arg)).thenReturn("1.0");

        //When
        String result = commandService.handleCommand(arg);

        //Then
        assertTrue(result.equals("1.0"));
    }

    @Test
    public void testHandleCommandForVersionWithArg() throws EmptyInputException {
        //Given
        String arg = "version 2.0";
        when(commandFactory.handleCommand(arg)).thenReturn("2.0");

        //When
        String result = commandService.handleCommand(arg);

        //Then
        assertTrue(result.equals("2.0"));
    }

    @Test
    public void testHandleCommandForTime() throws EmptyInputException {
        //Given
        String arg = "time";
        when(commandFactory.handleCommand(arg)).thenReturn(LocalTime.now().toString());

        //When
        String result = commandService.handleCommand(arg);

        //Then
        assertThat(LocalTime.now()).isCloseTo(LocalTime.parse(result), within(1, ChronoUnit.SECONDS));
    }

    @Test
    public void testHandleCommandForTimeWithArg() throws EmptyInputException {
        //Given
        String arg = "time next";
        when(commandFactory.handleCommand(arg)).thenReturn("NEXT");

        //When
        String result = commandService.handleCommand(arg);

        //Then
        assertTrue(result.equals("NEXT"));
    }

    @Test
    public void testHelp() throws EmptyInputException {
        String arg = "help";
        when(commandFactory.help(arg)).thenReturn("ping, version, time");

        //When
        String result = commandService.help(arg);

        //Then
        assertTrue(result.equals("ping, version, time"));
    }

    @Test
    public void testHelpForVersion() throws EmptyInputException {
        String arg = "help version";
        when(commandFactory.help(arg)).thenReturn("Prints current version");

        //When
        String result = commandService.help(arg);

        //Then
        assertTrue(result.equals("Prints current version"));
    }

    @Test
    public void testHelpForTime() throws EmptyInputException {
        String arg = "help time";
        when(commandFactory.help(arg)).thenReturn("Prints current time");

        //When
        String result = commandService.help(arg);

        //Then
        assertTrue(result.equals("Prints current time"));
    }

    @Test
    public void testHelpForPing() throws EmptyInputException {
        String arg = "help ping";
        when(commandFactory.help(arg)).thenReturn("Prints pong");

        //When
        String result = commandService.help(arg);

        //Then
        assertTrue(result.equals("Prints pong"));
    }
}
