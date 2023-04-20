package io.acaeronte.jdbc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NamedParameterStatement implements AutoCloseable{

    private final PreparedStatement statement;
    private final Map<String,Object> indexMap = new HashMap<>();

    public NamedParameterStatement(Connection connection, String query) throws SQLException {
        String parsedQuery = parse(query, this.indexMap);
        this.statement = connection.prepareStatement(parsedQuery);
    }

    private String parse(String query, Map<String, Object> indexMap) {
        return "";//TODO falta implementar este metodo
    }

    public void close() throws Exception {
        this.statement.close();
    }
}
