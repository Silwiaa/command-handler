package com.recruitmenttask.commandrunner;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandValidator {
    public String checkMethod(String arg) throws EmptyInputException {
        if (arg.isEmpty()) throw new EmptyInputException("Input can not be null");

        int index = arg.indexOf(" ");
        if (index == -1 ) throw new IllegalStateException("Unexpected value: " + arg);

        validateMethod(arg.substring(0, index));
        return arg.substring(index + 1);
    }

    private void validateMethod(String arg) {
        List<String> methodList = Arrays.stream(Method.values()).map(Method::getMethod).collect(Collectors.toList());
        if (!methodList.contains(arg.toUpperCase())) throw new IllegalStateException("Unexpected value: " + arg);
    }
}
