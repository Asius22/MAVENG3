import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private Connection connection;
    public static final String DB_USER = "root",
            DB_PWD = "123456sette",
            DB_URL = "jdbc:mysql://localhost/JDBC?",
            DB_CLASS = "com.mysql.cj.jdbc.Driver";
    public DBConnector (){
        createConnection();
    }

    private Connection createConnection(){
        try{
            Class.forName(DB_CLASS).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            return connection;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
