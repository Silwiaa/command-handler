package com.recruitmenttask.commandrunner;

import org.springframework.stereotype.Component;

public enum Method {
    VERSION("VERSION"),
    PING("PING"),
    TIME("TIME");
    String method;

    Method(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
