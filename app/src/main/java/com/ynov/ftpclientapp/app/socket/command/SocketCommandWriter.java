package com.ynov.ftpclientapp.app.socket.command;

import com.ynov.ftpclientapp.app.socket.NetworkConnection;
import com.ynov.ftpclientapp.app.socket.ServerResponseImpl;
import com.ynov.ftpclientapp.app.socket.exception.AuthenticationFailureException;
import com.ynov.ftpclientapp.app.socket.exception.ConnectionUnavailableException;
import com.ynov.ftpclientapp.app.socket.exception.HostUnavailableException;
import com.ynov.ftpclientapp.app.socket.exception.UserNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class SocketCommandWriter {

    private final static int DEFAULT_PORT = 21;

    private Socket socket;
    private NetworkConnection networkConnection;

    private PrintWriter out;
    private BufferedReader in;

    public SocketCommandWriter(String hostname, int port, NetworkConnection networkConnection) throws IOException, UserNotFoundException, ConnectionUnavailableException, HostUnavailableException, AuthenticationFailureException {
        this.networkConnection = networkConnection;
        createSocket(hostname, port);
        out = new PrintWriter(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        connect();
    }

    public SocketCommandWriter(String hostname, int port, String login, String password) throws IOException, UserNotFoundException, ConnectionUnavailableException, HostUnavailableException, AuthenticationFailureException {
        this(hostname, port, new NetworkConnection(login, password));
    }

    public SocketCommandWriter(String hostname, String login, String password) throws IOException, UserNotFoundException, ConnectionUnavailableException, HostUnavailableException, AuthenticationFailureException {
        this(hostname, DEFAULT_PORT, new NetworkConnection(login, password));
    }

    public SocketCommandWriter(String hostname) throws IOException, UserNotFoundException, ConnectionUnavailableException, HostUnavailableException, AuthenticationFailureException {
        this(hostname, DEFAULT_PORT, new NetworkConnection());
    }

    public void createSocket(String hostname) throws IOException {
        createSocket(hostname, DEFAULT_PORT);
    }

    public void createSocket(String hostname, int port) throws IOException {
        this.socket = new Socket(InetAddress.getByName(new URL("ftp://ftp.helpline.fr").getHost()).getHostAddress(), port);
    }

    public void connect() throws UserNotFoundException, ConnectionUnavailableException, HostUnavailableException, IOException, AuthenticationFailureException {
        noop();
        sendUsername();
        sendPassword();
    }

    private void sendPassword() throws ConnectionUnavailableException, IOException, AuthenticationFailureException {
        ServerResponseImpl response = sendCommand(CommandFTP.PASSWORD.getCmd() + " " + networkConnection.getPassword());
        switch (Integer.parseInt(response.getResponse().substring(0, 3))) {
            case 125:
                return;
            default:
                throw new AuthenticationFailureException();

        }
    }

    public ServerResponseImpl sendCommand(String command) throws IOException {
        out.println(command);
        out.flush();
        return new ServerResponseImpl(in.readLine());
    }

    private void sendUsername() throws UserNotFoundException, HostUnavailableException, ConnectionUnavailableException, IOException, AuthenticationFailureException {
        ServerResponseImpl response = sendCommand(CommandFTP.USER.getCmd() + " " + networkConnection.getLogin());
        switch (Integer.parseInt(response.getResponse().substring(0, 3))) {
            case 331:
                return;
            default:
                throw new UserNotFoundException();

        }
    }

    private void noop() throws IOException {
        ServerResponseImpl response = sendCommand(CommandFTP.NO_OPERATION.getCmd());
    }
}
