package com.recruitmenttask.commandrunner.command;

public interface Command {
    String run();
    String getDescription(String arg);
}