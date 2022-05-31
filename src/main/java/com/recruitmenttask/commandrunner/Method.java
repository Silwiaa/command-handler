package com.recruitmenttask.commandrunner;

import lombok.Getter;

@Getter
public enum Method {
    VERSION("VERSION"),
    PING("PING"),
    TIME("TIME");
    String method;

    Method(String method) {
        this.method = method;
    }
}
