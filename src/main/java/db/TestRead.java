package db;

import utils.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestRead {
    public static void main(String[] args) {
        Log l = Log.getInstance();
        DBConnector db = DBConnector.getIstance();
        String query = "SELECT * FROM studente";
        try {
            PreparedStatement stat = db.getPreparedStatement(query);
            ResultSet res = stat.executeQuery();
            ResultSetMetaData md = res.getMetaData();
            while (res.next())
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    l.info(res.getString(i) + "\n");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
