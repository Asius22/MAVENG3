package esercitazione2;

import db.DBConnector;
import utils.Log;

import java.sql.SQLException;

public abstract class StatementThread implements Runnable {
    protected String query;
    protected static final Log L = Log.getInstance();
    protected static final DBConnector connector = DBConnector.getIstance();

    protected StatementThread(String query) {
        this.query = query;
    }

    public void closeAll() throws SQLException {
        connector.closeConnection();
    }
}
