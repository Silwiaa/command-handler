package com.recruitmenttask.commandrunner.service;

import com.recruitmenttask.commandrunner.CommandFactory;
import com.recruitmenttask.commandrunner.EmptyInputException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommandService {
    private final CommandFactory commandFactory;

    public String handleCommand(String commandName) throws EmptyInputException {
        return commandFactory.handleCommand(commandName);
    }

    public String help(String arg) throws EmptyInputException {
        return commandFactory.help(arg);
    }
}
