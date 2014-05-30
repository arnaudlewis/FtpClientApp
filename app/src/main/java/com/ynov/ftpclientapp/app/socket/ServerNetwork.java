package com.ynov.ftpclientapp.app.socket;

import com.ynov.ftpclientapp.app.socket.flow.ServerResponse;

/**
 * Created by arnaud on 31/05/2014.
 */
public interface ServerNetwork {

    public void create(String hostname, String login, String password);

    public ServerResponse sendCommand(String command);


}
