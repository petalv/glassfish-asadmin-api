package se.glassfish.asadmin.api.command;

public enum JdbcIsolationLevel {

    READ_UNCOMMITTED("read-uncommitted"), READ_COMITTED("read-committed"), REPEATABLE_READ("repeatable-read"),
    SERIALIZABLE("serializable");


    private final String NAME;

    JdbcIsolationLevel(String name) {
        this.NAME = name;
    }

    public String getName() {
        return NAME;
    }

}
