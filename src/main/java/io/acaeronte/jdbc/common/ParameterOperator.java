package io.acaeronte.jdbc.common;

public enum ParameterOperator {
    EQUALS("="),
    NOT_EQUALS("!="),
    IN("IN"),
    NOT_IN("NOT IN"),
    GREATER_EQUALS(">="),
    LESS_EQUALS("<="),
    SAME_FIELD("="),
    NULL("IS NULL"),
    NOT_NULL("IS NOT NULL"),
    DISTINC_FROM("IS DISTINCT FROM "),
    LIKE("LIKE");


    private final String value;

    ParameterOperator(String val){
        this.value=val;
    }

    public String getValue(){
        return this.value;
    }

    public static ParameterOperator fromValue(String value){
        for (ParameterOperator e :values()) {
            if (e.name().equals(value)){
                return e;
            }
        }
        return null;
    }


}
