package io.acaeronte.jdbc.connection;

import java.sql.Connection;

public class JdbcConnection implements AutoCloseable{

    private final Connection connection;

    public JdbcConnection(Connection connection){
        this.connection = connection;
    }

    @Override
    public void close() throws Exception {
        this.connection.close();

    }
}
