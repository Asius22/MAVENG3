package esercitazione2;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteThread extends StatementThread {
    private int id;

    public DeleteThread(String s, int id) {
        super(s);
        this.id = id;
    }

    @Override
    public void run() {
        if (!query.toLowerCase().contains("delete")) {
            L.error("Inserita query errata...\nRiprovare");
            return;
        }
        try {
            PreparedStatement stat = connector.getPreparedStatement(query);
            stat.setInt(1, id);
            int res = stat.executeUpdate();

            L.info(
                    res > 0 ? "DELETE: Riuscita" : "DELETE: qualcosa è andato storto"
            );

            stat.close();
        } catch (SQLException e) {
            L.error(e.getMessage() + e.getErrorCode());
            e.printStackTrace();
        }
    }
}
