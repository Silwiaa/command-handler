package com.recruitmenttask.commandrunner.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@ExtendWith(MockitoExtension.class)
public class CommandValidatorTestSuite {
    @InjectMocks
    private CommandValidator commandValidator;

    @Test
    public void shouldReturnTrue() {
        //Given
        String arg = "VERSION";

        //When
        boolean result = commandValidator.isNoArgument(arg);

        //Then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse() {
        //Given
        String arg = "VERSION 1.0";

        //When
        boolean result = commandValidator.isNoArgument(arg);

        //Then
        assertFalse(result);
    }
}