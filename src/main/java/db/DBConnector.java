package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private static final Log l = Log.getInstance();
    private static final String DB_USER = "db.username", DB_URL = "db.url", DB_PWD = "db.password", DB_CLASS = "db.class";
    private static DBConnector connector;
    private Connection connection;
    private Readproperties properties;

    private DBConnector() {
        createConnection();
        try {
            properties = new Readproperties();
        } catch (IOException e){
            e.printStackTrace();
            l.error(e.getMessage());
        }
        connector = this;
    }

    private void createConnection() {
        if (connection == null) {
            Properties prop = properties.getProp();
            try {
                Class.forName(prop.getProperty(DB_CLASS))
                        .getDeclaredConstructor()
                        .newInstance();
                connection = DriverManager.getConnection(
                        prop.getProperty(DB_URL),
                        prop.getProperty(DB_USER),
                        prop.getProperty(DB_PWD)
                );
            } catch (Exception e) {
                e.printStackTrace();
                l.error(e.getMessage());
            }
        }
    }

    public static DBConnector getIstance() {
        if (connector == null)
            connector = new DBConnector();
        return connector;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public PreparedStatement getPreparedStatement(String s) throws SQLException {
        return connection.prepareStatement(s);
    }
}
