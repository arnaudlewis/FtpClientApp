package com.ynov.ftpclientapp.app.socket;

import com.ynov.ftpclientapp.app.socket.command.SocketCommandWriter;
import com.ynov.ftpclientapp.app.socket.flow.SocketFlowReader;

/**
 * Created by arnaud on 31/05/2014.
 */
public class ServerNetworkImpl implements ServerNetwork {

    private NetworkConnection networkConnection;
    private SocketCommandWriter commandWriter;
    private SocketFlowReader flowReader;

    @Override
    public ServerResponse create(String hostname, String login, String password) {
        return null;
    }

    @Override
    public ServerResponse sendCommand(String command) {
        return null;
    }
}
