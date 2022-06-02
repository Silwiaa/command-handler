package com.recruitmenttask.commandrunner.factory;

import com.recruitmenttask.commandrunner.exception.EmptyInputException;
import com.recruitmenttask.commandrunner.validator.CommandValidator;
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
public class CommandFactoryTestSuite {
    @InjectMocks
    private CommandFactory commandFactory;

    @Mock
    private CommandValidator commandValidator;

    @Test
    public void shouldHandleVersionWithNoArgCommand() throws EmptyInputException {
        //Given
        String command = "VERSION";
        when(commandValidator.isNoArgument(command)).thenReturn(true);

        //When
        String result = commandFactory.handleCommand(command);

        //Then
        assertTrue(result.equals("1.0"));
    }

    @Test
    public void shouldHandleVersionWithArgCommand() throws EmptyInputException {
        //Given
        String command = "VERSION 2.0";
        when(commandValidator.isNoArgument(command)).thenReturn(false);

        //When
        String result = commandFactory.handleCommand(command);

        //Then
        assertTrue(result.equals("2.0"));
    }

    @Test
    public void shouldHandlePingWithNoArgCommand() throws EmptyInputException {
        //Given
        String command = "PING";
        when(commandValidator.isNoArgument(command)).thenReturn(true);

        //When
        String result = commandFactory.handleCommand(command);

        //Then
        assertTrue(result.equals("PONG"));
    }

    @Test
    public void shouldHandlePingWithArgCommand() throws EmptyInputException {
        //Given
        String command = "PING NEXT";
        when(commandValidator.isNoArgument(command)).thenReturn(false);

        //When
        String result = commandFactory.handleCommand(command);

        //Then
        assertTrue(result.equals("NEXT"));
    }

    @Test
    public void shouldHandleTimeWithNoArgCommand() throws EmptyInputException {
        //Given
        String command = "TIME";
        when(commandValidator.isNoArgument(command)).thenReturn(true);

        //When
        String result = commandFactory.handleCommand(command);

        //Then
        assertThat(LocalTime.now()).isCloseTo(LocalTime.parse(result), within(1, ChronoUnit.SECONDS));
    }

    @Test
    public void shouldHandleTimeWithArgCommand() throws EmptyInputException {
        //Given
        String command = "TIME NEXT";
        when(commandValidator.isNoArgument(command)).thenReturn(false);

        //When
        String result = commandFactory.handleCommand(command);

        //Then
        assertTrue(result.equals("NEXT"));
    }

    @Test
    public void shouldHelp() throws EmptyInputException {
        String passedCommand = "HELP";
        when(commandValidator.isNoArgument(passedCommand)).thenReturn(true);

        //When
        String result = commandFactory.help(passedCommand);

        //Then
        assertTrue(result.equals("ping, time, version"));
    }

    @Test
    public void shouldHelpForVersion() throws EmptyInputException {
        String passedCommand = "HELP VERSION";
        when(commandValidator.isNoArgument(passedCommand)).thenReturn(false);

        //When
        String result = commandFactory.help(passedCommand);

        //Then
        assertTrue(result.equals("Prints current version"));
    }

    @Test
    public void shouldHelpForTime() throws EmptyInputException {
        String passedCommand = "HELP TIME";
        when(commandValidator.isNoArgument(passedCommand)).thenReturn(false);

        //When
        String result = commandFactory.help(passedCommand);

        //Then
        assertTrue(result.equals("Prints current time"));
    }

    @Test
    public void shouldHelpForPing() throws EmptyInputException {
        String passedCommand = "HELP PING";
        when(commandValidator.isNoArgument(passedCommand)).thenReturn(false);

        //When
        String result = commandFactory.help(passedCommand);

        //Then
        assertTrue(result.equals("Prints pong"));
    }
}
