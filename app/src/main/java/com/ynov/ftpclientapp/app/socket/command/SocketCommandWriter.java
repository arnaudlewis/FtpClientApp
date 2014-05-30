package com.ynov.ftpclientapp.app.socket.command;

import com.ynov.ftpclientapp.app.socket.NetworkConnection;
import com.ynov.ftpclientapp.app.socket.action.Connect;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketCommandWriter {

    private final static int DEFAULT_PORT = 20;

    private Socket socket;
    private NetworkConnection networkConnection;

    private Thread tConnection;

    public SocketCommandWriter(String hostname, int port, NetworkConnection networkConnection) {
        this.socket = createSocket(hostname, port);
        this.networkConnection = networkConnection;
        connect();
    }

    public SocketCommandWriter(String hostname, int port, String login, String password) {
        this(hostname, port, new NetworkConnection(login, password));
    }

    public SocketCommandWriter(String hostname, String login, String password) {
        this(hostname, DEFAULT_PORT, new NetworkConnection(login, password));
    }

    public SocketCommandWriter(String hostname) {
        this(hostname, DEFAULT_PORT, new NetworkConnection());
    }


    private void connect() {
        tConnection = this.networkConnection.connect(socket);
        tConnection.start();
    }

    public Socket createSocket(String hostname) {
        return createSocket(hostname, DEFAULT_PORT);
    }

    public Socket createSocket(String hostname, int port) {
        try {
            return new Socket(InetAddress.getByName(hostname), port);

        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
