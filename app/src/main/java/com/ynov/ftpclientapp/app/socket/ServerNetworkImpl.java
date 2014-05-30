package com.ynov.ftpclientapp.app.socket;

import com.ynov.ftpclientapp.app.socket.command.SocketCommandWriter;
import com.ynov.ftpclientapp.app.socket.flow.ServerResponse;
import com.ynov.ftpclientapp.app.socket.flow.SocketFlowReader;

/**
 * Created by arnaud on 31/05/2014.
 */
public class ServerNetworkImpl implements ServerNetwork {

    private NetworkConnection networkConnection;
    private SocketCommandWriter commandWriter;
    private SocketFlowReader flowReader;

    @Override
    public void create(String hostname, String login, String password) {

    }

    @Override
    public ServerResponse sendCommand(String command) {
        return null;
    }
}
