package com.recruitmenttask.commandrunner.command;

public class Ping implements Command {
    private static final String NAME = "PING";
    private String arg;
    public Ping(String arg) {
        this.arg = arg;
    }
    public Ping(){};

    @Override
    public String run() {
        if (arg.equals(NAME)) {
            return "PONG";
        } else {
            return arg;
        }
    }

    @Override
    public String getDescription(String commandName) {
        return "Prints pong";
    }
}
