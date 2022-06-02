package com.recruitmenttask.commandrunner;

import com.recruitmenttask.commandrunner.exception.EmptyInputException;
import com.recruitmenttask.commandrunner.validator.CommandValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CommandValidatorTestSuite {
    @InjectMocks
    private CommandValidator commandValidator;

    @Test
    public void testCheckMethodWithArgument() throws EmptyInputException {
        //Given
        String arg = "NEXT";
        String command = Method.PING.getMethod();
        String method = command + " " + arg;

        //When
        String result = commandValidator.checkMethod(method);

        //Then
        assertEquals(arg, result);
    }

    @Test
    public void whenEmptyInputExceptionThrown_thenAssertionSucceds() {
        Exception exception = assertThrows(EmptyInputException.class, () -> {
            commandValidator.checkMethod("");
        });

        String expectedMessage = "Input can not be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenIllegalStateExceptionThrown_thenAssertionSucceds() {
        String arg = "NotValid";
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            commandValidator.checkMethod(arg);
        });

        String expectedMessage = "Unexpected value: " + arg;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
