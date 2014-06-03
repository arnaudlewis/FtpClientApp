package com.ynov.ftpclientapp.app.socket;

/**
 * Created by arnaud on 31/05/2014.
 */
public interface ServerResponse<T> {

    public T getResponse();

    public void setResponse(T response);

    public String getDetails();

    public void setDetails(String details);
}
