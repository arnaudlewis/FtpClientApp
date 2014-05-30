package com.ynov.ftpclientapp.app.socket;

import com.ynov.ftpclientapp.app.socket.action.Connect;

import java.net.Socket;

/**
 * Created by arnaud on 31/05/2014.
 */
public class NetworkConnection {

    private String login;
    private String password;

    private static final String DEFAULT_LOGIN ="anonymous";
    private static final String DEFAULT_PASSWORD = "";

    public NetworkConnection(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public NetworkConnection() {
        this(DEFAULT_LOGIN, DEFAULT_PASSWORD);
    }

    public Thread connect(Socket socket) {
        return new Thread(new Connect(socket, login, password));
    }
}
