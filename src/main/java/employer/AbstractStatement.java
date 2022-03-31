package employer;

import db.DBConnector;
import db.Readproperties;
import lombok.Data;
import utils.Log;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public abstract class AbstractStatement implements Runnable{
    private PreparedStatement statement;
    private Log L = Log.getInstance();
    protected static final DBConnector connector = DBConnector.getIstance();
    private Readproperties reader;

    protected AbstractStatement() throws IOException {
        reader = new Readproperties("employer.properties");
    }

    public abstract void print();

    public void close() throws SQLException {
        connector.closeConnection();
        statement.close();

    }
}
