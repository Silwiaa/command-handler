package com.recruitmenttask.commandrunner.command;

import com.recruitmenttask.commandrunner.Command;
import org.springframework.stereotype.Component;

@Component
public class Version implements Command {
    private static final String NAME = "VERSION";
    private String arg;
    public Version(String arg) {
        this.arg = arg;
    }
    public Version(){};

    @Override
    public String run() {
        if (arg.equals(NAME)) {
            return "1.0";
        } else {
            return arg;
        }
    }

    @Override
    public String getDescription(String commandName) {
        return "Prints current version";
    }
}
