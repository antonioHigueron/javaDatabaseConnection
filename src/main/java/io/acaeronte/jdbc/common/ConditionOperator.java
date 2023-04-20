package io.acaeronte.jdbc.common;

public enum ConditionOperator {
    AND("AND"),
    OR("OR");

    private final String value;

    ConditionOperator(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
