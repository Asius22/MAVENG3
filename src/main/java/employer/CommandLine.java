package employer;

import utils.Log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Applicazione anagrafica v
 * progetto maven v
 * connessione db v
 * lettura tabella
 * classe command line
 * employee (id pk, name, lastname)
 * print nome, cognome e id
 * annotation logger con value per metodi
 */
public class CommandLine {
    private int choice;
    private Scanner scan;
    private Log l = Log.getInstance();
    private AbstractStatement statement;

    public CommandLine() throws IOException {
        scan = new Scanner(System.in);
        choice = -1;
    }

    @Logger("start")
    public void start() throws SQLException, IOException{
        while (choice != 0) {
            chiediScelta();
            elaboraScelta();
        }
    }

    private void chiediScelta() {
        l.info("Cosa vuoi fare? " +
                "\n1) Crea" +
                "\n2) leggi" +
                "\n3) insert" +
                "\n4) delete" +
                "\n0) esci");
        choice = scan.nextInt();
    }

    @Logger("elaboro...")
    private void elaboraScelta() throws SQLException, IOException {
        switch (choice) {
            case 1 -> statement = new CreateStatement();
            case 2 -> statement = new ReadStatement();
            case 3 -> statement = new InsertStatement();
            case 4 -> statement = new DeleteStatement()
        }
        execute();
    }

    private void execute() {
        try {
            Thread t = new Thread(statement);
            t.start();
            t.join();
        } catch (InterruptedException e) {
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
