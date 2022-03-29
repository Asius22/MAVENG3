import org.apache.log4j.xml.Log4jEntityResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        DBConnector connector = new DBConnector();
        try {

          /*  String query = "CREATE TABLE jdbc.fornitore (" +
                    "  `codiceFornitore` VARCHAR(20) NOT NULL," +
                    "  `nome` VARCHAR(20) NOT NULL," +
                    "  `indirizzo` VARCHAR(20) NOT NULL," +
                    "  `citta` VARCHAR(20) NOT NULL," +
                    "  PRIMARY KEY (`codiceFornitore`)); ";

            PreparedStatement stat = conn.prepareStatement(query);
            int res = stat.executeUpdate();
            System.out.println(
                    (res == 0) ? "Creazione completata" : "c'è stato un problema"
            );*/

            String insert1 = "INSERT INTO JDBC.FORNITORE (codiceFornitore, nome, indirizzo, citta)" +
                    "VALUES ('001', 'ladroni', 'Via ostense', 'roma'), " +
                    "('002', 'risparmietti', 'Viale marconi', 'Roma')";

            PreparedStatement stat = connector.getPrepaaredStatement(insert1);
            int res = stat.executeUpdate();

            System.out.println(
                    (res > 0) ? "Inserimento completaato" : "qualcosa è andato storto"
            );

            stat.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection();
        }
    }
}
