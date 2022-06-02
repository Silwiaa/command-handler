package com.recruitmenttask.commandrunner.command;

import com.recruitmenttask.commandrunner.Command;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Time implements Command {
    private static final String NAME = "TIME";
    private String arg;
    public Time(String arg) {
        this.arg = arg;
    }
    public Time(){};

    @Override
    public String run() {
        if (arg.equals(NAME)) {
            return LocalTime.now().toString();
        } else {
            return arg;
        }
    }

    @Override
    public String getDescription(String commandName) {
        return "Prints current time";
    }
}
