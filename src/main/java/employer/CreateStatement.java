package employer;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateStatement extends AbstractStatement {
    private static final String KEY = "db.create";
    private int res;
    public CreateStatement() throws SQLException, IOException {
        super();
        setStatement(
                connector.getPreparedStatement(
                        getReader().getProp().getProperty(KEY)
                )
        );
        res = -1;
    }

    /**
     * legge il file application.properties
     * legge la chiave per la creazione
     * lancia il comando letto
     * @throws SQLException
     */
    @Logger("CreateStatement.run")
    @Override
    public void run() {
        try {
            res = getStatement().executeUpdate();
        } catch (SQLException e){
            getL().error(e.getMessage());
            e.printStackTrace();
        }
        print();
    }

    @Override
    public void print() {
        getL().info(
                (res == 0) ? "Crezione riuscita" : "Qualcosa è andato storto"
        );
    }

}
