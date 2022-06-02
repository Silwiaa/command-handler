package com.recruitmenttask.commandrunner.factory;

import com.recruitmenttask.commandrunner.command.*;
import com.recruitmenttask.commandrunner.exception.EmptyInputException;
import com.recruitmenttask.commandrunner.validator.CommandValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public final class CommandFactory {
    private final CommandValidator commandValidator;

    public String handleCommand(String passedCommand) throws EmptyInputException {
        if (passedCommand.isEmpty()) throw new EmptyInputException("Input can not be null");

        passedCommand = passedCommand.toUpperCase();
        String arg;
        String commandName;

        if (commandValidator.isNoArgument(passedCommand)) {
            arg = passedCommand;
            commandName = passedCommand;
        } else {
            arg = getArg(passedCommand);
            commandName = passedCommand.substring(0, passedCommand.indexOf(" "));
        }

        Command command;
        switch(commandName) {
            case "VERSION":
                command = new Version(arg);
                break;
            case "PING":
                command = new Ping(arg);
                break;
            case "TIME":
                command = new Time(arg);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + passedCommand);
        }
        return command.run();
    }

    public String help(String passedCommand) throws EmptyInputException {
        if (passedCommand.isEmpty()) throw new EmptyInputException("Input can not be null");

        passedCommand = passedCommand.toUpperCase();
        String arg;
        String commandName;

        if (commandValidator.isNoArgument(passedCommand)) {
            return getMethods();
        } else {
            commandName = passedCommand.substring(passedCommand.indexOf(" ") + 1);
            arg = getArg(passedCommand);
            Command command;
            switch(commandName) {
                case "VERSION":
                    command = new Version();
                    break;
                case "PING":
                    command = new Ping();
                    break;
                case "TIME":
                    command = new Time();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + arg);
            }
            return command.getDescription(arg);
        }
    }

    private String getArg(String passedCommand) {
        return passedCommand.substring(passedCommand.indexOf(" ") + 1);
    }

    private String getMethods() {
        //will be refactored
        return "All methods";
    }
}