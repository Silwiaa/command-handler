package com.recruitmenttask.commandrunner;

public interface Command {
    String run();
    String getDescription(String arg);
}