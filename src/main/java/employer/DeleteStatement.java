package employer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStatement extends AbstractStatement{

    private int id, res;
    private static final String KEY = "db.delete";
    public DeleteStatement() throws SQLException, IOException {
        setStatement(
                connector.getPreparedStatement(
                        getReader().getProp().getProperty(KEY)
                )
        );
    }

    @Override
    public void print(){
        getL().info(
                (res > 0) ? "Eliminazone riuscita" : "dato non trovato"
        );
    }

    @Override
    public void run() {
        askId();
        try {
            getStatement().setInt(1, id);
            res = getStatement().executeUpdate();
        } catch (SQLException e){
            getL().error(e.getMessage());
            e.printStackTrace();
        }

        print();
    }

    private void askId(){
        Scanner scan = new Scanner(System.in);
        getL().info("Quale id vuoio eliminare=");
        id = scan.nextInt();
    }
}
