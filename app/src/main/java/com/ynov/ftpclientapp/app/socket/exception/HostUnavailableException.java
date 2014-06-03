package com.ynov.ftpclientapp.app.socket.exception;

/**
 * Created by arnaud on 31/05/2014.
 */
public class HostUnavailableException extends Exception {
    public HostUnavailableException() {
        super("The host is unavailable, please try something else");
    }
}
