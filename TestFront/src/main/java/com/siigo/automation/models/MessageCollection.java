package com.siigo.automation.models;

public enum MessageCollection {

    MSG_CREATE_UNSUCCESSFUL("Unsuccessful creations");

    private String stringMsg;

    MessageCollection(String msg) {
        this.stringMsg = msg;
    }

    public String getMsg() {
        return stringMsg;
    }
}
