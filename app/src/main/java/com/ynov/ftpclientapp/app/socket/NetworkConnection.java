package com.ynov.ftpclientapp.app.socket;

import java.net.Socket;

/**
 * Created by arnaud on 31/05/2014.
 */
public class NetworkConnection {

    private String login;
    private String password;

    private static final String DEFAULT_LOGIN ="anonymous";
    private static final String DEFAULT_PASSWORD = "anonymous";

    public NetworkConnection(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public NetworkConnection() {
        this(DEFAULT_LOGIN, DEFAULT_PASSWORD);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
