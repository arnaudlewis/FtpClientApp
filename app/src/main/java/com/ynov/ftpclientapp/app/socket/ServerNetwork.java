package com.ynov.ftpclientapp.app.socket;

import java.io.IOException;

/**
 * Created by arnaud on 31/05/2014.
 */
public interface ServerNetwork {

    public ServerResponse create(String hostname, String login, String password);

    public ServerResponse create(String hostname);

    public ServerResponse create(String hostname, NetworkConnection networkConnection);

    public ServerResponse sendCommand(String command) throws IOException;


}
