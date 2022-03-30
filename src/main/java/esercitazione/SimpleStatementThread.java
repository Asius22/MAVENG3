package esercitazione;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * questa classe crea un nuovo metodo che si occupa di leggere la tabella
 */
public class SimpleStatementThread extends StatementThread{
    /**
     *
     * @param stat
     */
    public SimpleStatementThread(PreparedStatement stat){
        super(stat);
    }

    @Override
    public void run() {
        try{
            ResultSet res = stat.executeQuery();

            while (res.next()) {
                for (int i = 1; i < (res.getMetaData().getColumnCount()); i++)
                    L.info(res.getString(i));
                L.info("\n");
            }

        } catch (SQLException e) {
            L.debug(e.getMessage() + " " + e.getErrorCode());
            e.printStackTrace();
        }

        closeStat();

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
