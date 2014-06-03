package com.ynov.ftpclientapp.app.socket;

import com.ynov.ftpclientapp.app.socket.command.SocketCommandWriter;
import com.ynov.ftpclientapp.app.socket.exception.ConnectionUnavailableException;
import com.ynov.ftpclientapp.app.socket.flow.SocketFlowReader;

import java.io.IOException;

public class ServerNetworkImpl implements ServerNetwork {

    private SocketCommandWriter commandWriter;
    private SocketFlowReader flowReader;

    @Override
    public ServerResponse create(String hostname, String login, String password) {
        return create(hostname, new NetworkConnection(login, password));
    }

    @Override
    public ServerResponse create(String hostname) {
        return create(hostname, new NetworkConnection());
    }

    @Override
    public ServerResponse create(String hostname, NetworkConnection networkConnection) {
        try {
            this.commandWriter = new SocketCommandWriter(hostname, networkConnection.getLogin(), networkConnection.getPassword());
            //this.flowReader = new SocketFlowReader(hostname, login, password);
            return new ServerResponseImpl("ok");
        } catch(Exception e) {
            e.printStackTrace();
            return new ServerResponseImpl("ko", e.getMessage());
        } catch (ConnectionUnavailableException e) {
            e.printStackTrace();
            return new ServerResponseImpl("ko", e.getMessage());
        }
    }

    @Override
    public ServerResponse sendCommand(String command) throws IOException {
        return commandWriter.sendCommand(command);
    }
}
