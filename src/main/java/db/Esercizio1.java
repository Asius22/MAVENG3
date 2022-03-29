package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Esercizio1 {

    public static void main(String[] args) throws SQLException {
        DBConnector connector = DBConnector.getIstance();
        String query = "CREATE TABLE `jdbc`.`prodotto` (" +
                "  id INT NOT NULL," +
                "  marca VARCHAR(45) NOT NULL," +
                "  tipo VARCHAR(20) NOT NULL," +
                "  modello VARCHAR(20) NOT NULL," +
                "  costo INT NOT NULL," +
                "  PRIMARY KEY (`ID`));";

        int res = -1;
        try (PreparedStatement stat = connector.getPreparedStatement(query)) {
            res = stat.executeUpdate();
        } catch (SQLException e) {
            connector.getLog().error(
                    e.getSQLState() +
                            " " +
                            e.getErrorCode() +
                            "\n" +
                            e.getMessage());
        } finally {
            connector.getLog().info(
                    res == 0 ? "Creazione riuscita" : "Si prega di riprovare"
            );
            connector.closeConnection();
        }
    }
}
