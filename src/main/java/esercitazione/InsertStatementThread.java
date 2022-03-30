package esercitazione;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * questa classe si occupa di creare un thread sul quale svolgere la procedura per inserire una nuova persona
 */
public class InsertStatementThread extends StatementThread {

    private boolean type; //true se deve creare, false altrimenti

    public InsertStatementThread(PreparedStatement stat, boolean type) {
        super(stat);
        this.type = type;
    }

    @Override
    public void run() {
        try {
            if (type)
                executeCreation();
            else
                executeInsert();
        } catch (SQLException e) {
            L.error(e.getMessage() + " : " + e.getSQLState() + " " + e.getErrorCode());
            e.printStackTrace();
        }

        closeStat();
    }

    private void executeCreation() throws SQLException {
        int res = stat.executeUpdate();

        L.info(
                res == 0 ? "Creazione effettuata" : "Qualcosa è andato storto"
        );
    }

    private void executeInsert() throws SQLException{
        Scanner scan = new Scanner(System.in);

        L.info("inserisci nome");
        stat.setString(1, scan.next());

        L.info("inserisci cognome");
        stat.setString(2, scan.next());

        L.info("inserisci eta");
        stat.setInt(3, scan.nextInt());

        L.info("inserisci citta");
        stat.setString(4, scan.next());

        L.info("inserisci provincia");
        stat.setString(5, scan.next());

        L.info("inserisci cap");
        stat.setInt(6, scan.nextInt());

        int res = stat.executeUpdate();

        L.info(
                res > 0 ? "Inserimento effettuato" : "Errore inserimento"
        );
    }


    private void closeStat() {
        try{
            stat.close();
        } catch (SQLException e){
            L.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
