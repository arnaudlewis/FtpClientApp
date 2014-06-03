package com.ynov.ftpclientapp.app.socket.exception;

/**
 * Created by arnaud on 02/06/2014.
 */
public class AuthenticationFailureException extends Exception{
    public AuthenticationFailureException() {
        super("Authentication failure, please try again");
    }
}
