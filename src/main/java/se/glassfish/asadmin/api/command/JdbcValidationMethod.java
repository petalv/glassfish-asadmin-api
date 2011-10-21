package se.glassfish.asadmin.api.command;

public enum JdbcValidationMethod {


    AUTO_COMMIT("auto-commit"),  META_DATA("meta-data"),  TABLE("table"), CUSTOM_VALIDATION("custom-validation");

    private final String NAME;

    JdbcValidationMethod(String name) {
        this.NAME = name;
    }

    public String getName() {
        return NAME;
    }

}
