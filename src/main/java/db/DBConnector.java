import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection;
    public static final String DB_USER = "root",
            DB_PWD = "123456sette",
            DB_URL = "jdbc:mysql://localhost/JDBC?",
            DB_CLASS = "com.mysql.cj.jdbc.Driver";

    private DBConnector() {
        createConnection();
    }

    private Connection createConnection() {
        try {
            Class.forName(DB_CLASS).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DBConnector getIstance(){
        if (connection == null)
            return new DBConnector();
        return this;
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
