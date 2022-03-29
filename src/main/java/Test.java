import org.apache.log4j.xml.Log4jEntityResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
    public static void main(String[] args)  {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/JDBC?", "root", "123456sette");

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

            PreparedStatement stat = conn.prepareStatement(insert1);
            int res = stat.executeUpdate();

            System.out.println(
                    (res > 0) ? "Inserimento completaato" : "qualcosa è andato storto"
            );
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
