package io.acaeronte.jdbc.exception;

public class JdbcException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public JdbcException(String message){
        super(message);
    }

    public JdbcException(Exception exception){
        super(exception);
    }

}
