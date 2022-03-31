package employer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStatement extends AbstractStatement {
    private Employer employer;
    private int res;
    private static final String KEY = "db.insert";

    public InsertStatement() throws IOException, SQLException {
        setStatement(
                connector.getPreparedStatement(
                        getReader().getProp().getProperty(KEY)
                )
        );

    }

    @Override
    public void print() {
        getL().info(
                (res > 0) ? "inserimento riuscito" : "inserimento non riuscito"
        );
    }

    @Override
    public void run() {
        setEmployer();

        try {
            getStatement().setString(1, employer.getName());
            getStatement().setString(2, employer.getLastName());
            res = getStatement().executeUpdate();
        } catch (SQLException e) {
            getL().info(e.getMessage());
            e.printStackTrace();
        }

        print();
    }

    private void setEmployer() {
        Scanner scan = new Scanner(System.in);
        String name, lastName;
        getL().info("inserisci nome");
        name = scan.nextLine();

        getL().info("inserisci lastName");
        lastName = scan.nextLine();

        employer = Employer.builder()
                .name(name)
                .lastName(lastName)
                .build();
    }
}
