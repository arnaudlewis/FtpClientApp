package com.ynov.ftpclientapp.app.socket;

/**
 * Created by arnaud on 31/05/2014.
 */
public class ServerResponseBinary implements ServerResponse<String> {

    private String response;

    public ServerResponseBinary(String response) {
        this.response = response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}
