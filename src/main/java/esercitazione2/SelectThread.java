package esercitazione2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SelectThread extends StatementThread {

    public SelectThread(String s) {
        super(s);
    }

    @Override
    public void run() {
        if (!query.toLowerCase().contains("select")) {
            L.error("Inserita query errata...\nRiprovare");
            return;
        }
        try {
            PreparedStatement stat = connector.getPreparedStatement(query);
            ResultSet res = stat.executeQuery();

            print(res);

            stat.close();
        } catch (SQLException e) {
            L.error(e.getMessage() + e.getErrorCode());
            e.printStackTrace();
        }
    }

    private void print(ResultSet res) throws SQLException {
        ResultSetMetaData md = res.getMetaData();
        while (res.next()) {
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= md.getColumnCount(); i++) {
                builder.append(res.getString(i)).append("\t\t");
            }
            L.info(builder.toString());
        }
    }
}