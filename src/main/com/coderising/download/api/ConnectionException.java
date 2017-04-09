package com.coderising.download.api;

public class ConnectionException extends Exception {

    public ConnectionException() {
        super();
    }

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(Exception e) {
        super(e);
    }
}
