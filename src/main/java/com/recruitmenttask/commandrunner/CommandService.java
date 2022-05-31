package com.recruitmenttask.commandrunner;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommandService implements CommandEngine{
    private final CommandRetriever commandRetriever;
    private final CommandValidator commandValidator;

    @Override
    public final String handleCommand(String command) throws EmptyInputException {
        switch(command) {
            case "VERSION":
                return commandRetriever.getVersion();
            case "PING":
                return commandRetriever.getPing();
            case "TIME":
                return commandRetriever.getTime();
            default:
                return commandRetriever.getArg(commandValidator.checkMethod(command));
        }
    }
}
