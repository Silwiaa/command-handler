package com.recruitmenttask.commandrunner.validator;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CommandValidator {
    public boolean isNoArgument(String arg) {
        int index = arg.indexOf(" ");
        if (index == -1 )  return true;
        return false;
    }
}
