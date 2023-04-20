package io.acaeronte.jdbc.connection;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ConnectionFactory {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public JdbcConnection build() throws SQLException{
        return new JdbcConnection(this.dataSource.getConnection());
    }

}
