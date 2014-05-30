package com.ynov.ftpclientapp.app.socket.action;

import java.net.Socket;

/**
 * Created by arnaud on 30/05/2014.
 */
public class Connect implements Runnable {

    private Socket socket;
    private String login;
    private String password;

    public Connect(Socket socket, String login, String password) {
        this.socket = socket;
        this.login = login;
        this.password = password;
    }

    @Override
    public void run() {

    }
}
