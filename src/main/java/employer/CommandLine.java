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
    public void start() {
        while (choice != 0) {
            chiediScelta();
            elaboraScelta();
        }
    }

    private void chiediScelta() {
        l.info("Cosa vuoi fare? " +
                "\n1) Crea" +
                "\n2) leggi" +
                "\n0) esci");
        choice = scan.nextInt();
    }
    @Logger("elaboro...")
    private void elaboraScelta(){
        switch(choice){
            case 1 -> createTable();
        }
    }

    private void createTable(){

        try {
            statement = new CreateStatement();
            Thread t = new Thread(statement);
            t.start();
            t.join();
        } catch (SQLException | IOException | InterruptedException e){
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
