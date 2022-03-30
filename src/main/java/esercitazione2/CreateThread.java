package esercitazione2;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateThread extends StatementThread {

    public CreateThread(String stat) {
        super(stat);
    }

    @Override
    public void run() {
        if (!query.toLowerCase().contains("create")) {
            L.error("Inserita query errata...\nRiprovare");
            return;
        }
        try {
            PreparedStatement stat = connector.getPreparedStatement(query);
            int res = stat.executeUpdate();

            L.info(
                    res == 0 ? "CREATE: Creazione riuscita" : "CREATE: Qualcosa è andato storto"
            );
            stat.close();
        } catch (SQLException e) {
            L.error(e.getMessage() + e.getErrorCode());
            e.printStackTrace();
        }
    }
}
