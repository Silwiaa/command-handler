package com.recruitmenttask;

import com.recruitmenttask.commandrunner.CommandFactory;
import com.recruitmenttask.commandrunner.CommandValidator;
import com.recruitmenttask.commandrunner.EmptyInputException;
import com.recruitmenttask.commandrunner.service.CommandService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) throws EmptyInputException {
        CommandService commandService = new CommandService(new CommandFactory(new CommandValidator()));
        System.out.println(commandService.handleCommand("version"));
        System.out.println(commandService.handleCommand("version x"));
        System.out.println(commandService.help("help"));
        System.out.println(commandService.help("help version"));
        //SpringApplication.run(CommandApplication.class, args);
    }
}
