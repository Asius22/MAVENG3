package employer;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ReadStatement extends AbstractStatement{
    private static final String KEY = "db.read";
    private ResultSet res;
    protected ReadStatement() throws IOException, SQLException {
        setStatement(
                connector.getPreparedStatement(
                        getReader().getProp().getProperty(KEY)
                )
        );
    }


    @Override
    public void print() throws SQLException {
        ResultSetMetaData md = res.getMetaData();
        StringBuilder str = new StringBuilder();
        while (res.next()){
            for (int i = 1; i < md.getColumnCount(); i++)
                str.append(
                        res.getString(i)
                ).append("\t\t");
        }
    }

    @Override
    public void run() {
        try {
            res = getStatement().executeQuery();
        } catch (SQLException e) {
            getL().error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        super.close();
        res.close();
    }
}
