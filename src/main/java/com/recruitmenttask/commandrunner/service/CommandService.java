package com.recruitmenttask.commandrunner.service;

import com.recruitmenttask.commandrunner.factory.CommandFactory;
import com.recruitmenttask.commandrunner.exception.EmptyInputException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommandService {
    private final CommandFactory commandFactory;

    public String handleCommand(String arg) throws EmptyInputException {
        return commandFactory.handleCommand(arg);
    }

    public String help(String arg) throws EmptyInputException {
        return commandFactory.help(arg);
    }
}
