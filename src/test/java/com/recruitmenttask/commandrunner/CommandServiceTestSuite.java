package com.recruitmenttask.commandrunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommandServiceTestSuite {
    @InjectMocks
    private CommandService commandService;

    @Mock
    private CommandRetriever commandRetriever;

    @Mock
    private CommandValidator commandValidator;

    @Test
    public void shouldHandleVersionCommand() throws EmptyInputException {
        //Given
        String command = Method.VERSION.getMethod();
        String version = "1.0";
        when(commandRetriever.getVersion()).thenReturn(version);

        //When
        String result = commandService.handleCommand(command);

        //Then
        assertTrue(result.equals(version));
    }

    @Test
    public void shouldHandlePingCommand() throws EmptyInputException {
        //Given
        String command = Method.PING.getMethod();
        String expectedVal = "PONG";
        when(commandRetriever.getPing()).thenReturn(expectedVal);

        //When
        String result = commandService.handleCommand(command);

        //Then
        assertTrue(result.equals(expectedVal));
    }

    @Test
    public void shouldHandleTimeCommand() throws EmptyInputException {
        //Given
        String command = Method.TIME.getMethod();
        String expectedVal = LocalTime.now().toString();
        when(commandRetriever.getTime()).thenReturn(expectedVal);

        //When
        String result = commandService.handleCommand(command);

        //Then
        assertTrue(result.equals(expectedVal));
    }

    @Test
    public void shouldHandleCommandWithArgument() throws EmptyInputException {
        //Given
        String command = Method.PING.getMethod() + " " + "NEXT";
        String expectedVal = "NEXT";
        when(commandValidator.checkMethod(command)).thenReturn(expectedVal);
        when(commandRetriever.getArg(expectedVal)).thenReturn(expectedVal);

        //When
        String result = commandService.handleCommand(command);

        //Then
        assertTrue(result.equals(expectedVal));
    }
}
