package com.ynov.ftpclientapp.app.socket;

/**
 * Created by arnaud on 31/05/2014.
 */
public class ServerResponseImpl implements ServerResponse<String> {

    private String response;
    private String details;

    public ServerResponseImpl(String response) {
        this.response = response;
    }

    public ServerResponseImpl(String response, String details) {
        this.response = response;
        this.details = details;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public void setDetails(String details) {
        this.details = details;
    }
}
