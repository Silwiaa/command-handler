package com.recruitmenttask.commandrunner;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class CommandRetriever {
    public String getVersion() {
        return "1.0";
    }

    public String getPing() {
        return "PONG";
    }

    public String getTime() {
        return LocalTime.now().toString();
    }

    public String getArg(String arg) {
        return arg;
    }
}
