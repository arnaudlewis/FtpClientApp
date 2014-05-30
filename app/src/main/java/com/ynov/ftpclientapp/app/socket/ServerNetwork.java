package com.ynov.ftpclientapp.app.socket;

/**
 * Created by arnaud on 31/05/2014.
 */
public interface ServerNetwork {

    public void create(String hostname, String login, String password);

    public ServerResponse sendCommand(String command);


}
