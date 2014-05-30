package com.ynov.ftpclientapp.app.socket.command;

/**
 * Created by oliver on 31/05/2014.
 */
public enum CommandFTP {

    TRANSFERT_ABORT("ABOR"),
    TYPE("TYPE"),

    CHANGE_WORKING_DIRECTORY("CWD"),
    CHANGE_TO_PARENT_DIRECTORY("CDUP"),

    DIRECTORY_CREATION("MKD"),
    DIRECTORY_REMOVE("RMV"),
    DIRECTORY_LIST("LIST"),

    DELETE("DELE"),
    RENAME_FILE_TO("RNTO"),
    RENAME_FILE_FROM("RNFR"),
    NO_OPERATION("NOOP"),
    QUIT_FTP_CONNECTION("QUIT"),

    USER("USER"),
    PASSWORD("PASS"),

    CHOOSE_PORT("PORT"),
    GIVE_PORT_AND_IP("PASV");


    private final String cmd;


    CommandFTP(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return this.cmd;
    }
}
