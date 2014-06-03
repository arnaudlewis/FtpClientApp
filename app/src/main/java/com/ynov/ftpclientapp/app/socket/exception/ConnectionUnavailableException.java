package com.ynov.ftpclientapp.app.socket.exception;

/**
 * Created by arnaud on 31/05/2014.
 */
public class ConnectionUnavailableException extends Throwable {
    public ConnectionUnavailableException() {
        super("Connection unavailable, try later");
    }
}
