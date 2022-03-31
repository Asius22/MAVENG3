package db;

import utils.DBConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Esercizio1 {

    public static void main(String[] args) throws SQLException {
        DBConnector connector = DBConnector.getIstance();
        String query = connector.getReader().getProp().getProperty("create");
        String insert = connector.getReader().getProp().getProperty("insert");
        String delete = connector.getReader().getProp().getProperty("drop");
        int res = -1;
        boolean delRes = false;
        try (PreparedStatement stat = connector.getPreparedStatement(delete)) {
            delRes = stat.execute();
        } catch (SQLException e) {
            connector.getLog().error(
                    e.getSQLState() +
                            " " +
                            e.getErrorCode() +
                            "\n" +
                            e.getMessage());
        } finally {
            connector.getLog().info(
                    !delRes ? "Eliminazione riuscita" : "Si prega di riprovare"
            );
        }

        try (PreparedStatement stat = connector.getPreparedStatement(query)) {
            res = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
        }

        try (PreparedStatement stat = connector.getPreparedStatement(insert)) {
            stat.setInt(1, 1);
            stat.setString(2, "Samsung");
            stat.setString(3, "telefono");
            stat.setString(4, "s22");
            stat.setInt(5, 1200);

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
                    res > 0 ? "inserimento riuscito" : "Si prega di riprovare"
            );
            connector.closeConnection();

        }


    }
}
