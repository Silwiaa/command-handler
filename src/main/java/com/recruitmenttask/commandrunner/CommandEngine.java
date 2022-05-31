package com.recruitmenttask.commandrunner;

public interface CommandEngine {
    String handleCommand(String command) throws EmptyInputException;
}