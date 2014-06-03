package com.ynov.ftpclientapp.app.socket.exception;

/**
 * Created by arnaud on 31/05/2014.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Username was not found");
    }
}
