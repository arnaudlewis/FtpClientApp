package com.ynov.ftpclientapp.app.socket;

/**
 * Created by arnaud on 31/05/2014.
 */
public class main {

    public static void main(String [] arg) {
        ServerNetwork server = new ServerNetworkImpl();
        server.create("ftp.free.fr");
    }
}
