package esercitazione2;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertThread extends StatementThread {
    private String marchio, nazione;
    private int fatturato, dipendenti;

    public InsertThread(String s, String marchio, String nazione, int fatturato, int dipendenti) {
        super(s);
        this.marchio = marchio;
        this.nazione = nazione;
        this.fatturato = fatturato;
        this.dipendenti = dipendenti;
    }

    @Override
    public void run() {
        if (!query.toLowerCase().contains("insert")) {
            L.error("Inserita query errata...\nRiprovare");
            return;
        }
        try {
            PreparedStatement stat = connector.getPreparedStatement(query);
            stat.setString(1, marchio);
            stat.setString(2, nazione);
            stat.setInt(3, fatturato);
            stat.setInt(4, dipendenti);
            int res = stat.executeUpdate();

            L.info(
                    res > 0 ? "INSERT: Riuscita" : "INSERT: qualcosa è andato storto"
            );
            stat.close();
        } catch (SQLException e) {
            L.error(e.getMessage() + e.getErrorCode());
            e.printStackTrace();
        }

    }
}
