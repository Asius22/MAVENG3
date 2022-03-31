package esercitazione;

import utils.DBConnector;

import java.sql.SQLException;

/**
 * anagrafica (id, nome, cognome, eta citta provincia cap)
 * scrivere un programma java che effettui l'inserimento dei nominativi e stampi i record
 * utilizzare i thread
 *
 * thread runnable che ha prepared statement e lo usa?
 * il main si occupa della creazione della tabella
 */
public class Test {
    public static void main(String[] args) {
        String create = "CREATE TABLE IF NOT EXISTS ANAGRAFICA(" +
                "id int not null auto_increment, " +
                "nome varchar(20) not null, " +
                "cognome varchar(20) not null, " +
                "eta int not null, " +
                "citta varchar(20) not null, " +
                "provincia varchar(3) not null, " +
                "cap int not null, " +
                "primary key (id));";

        String insert = "INSERT INTO ANAGRAFICA ( nome, cognome, eta, citta, provincia, cap) values (?,?,?,?,?,?)";
        String read = "SELECT * FROM ANAGRAFICA";

        DBConnector connector = DBConnector.getIstance();
        try{
            Thread creationThread = new Thread(new InsertStatementThread(
                    connector.getPreparedStatement(create),
                    true));

            Thread insertThread = new Thread( new InsertStatementThread(
                    connector.getPreparedStatement(insert),
                    false
            ));

            Thread readThread = new Thread(
                    new SimpleStatementThread(
                            connector.getPreparedStatement(read)
                    )
            );

            creationThread.start();
            insertThread.start();
            insertThread.join();
            readThread.start();

        } catch (SQLException e){
            connector.getLog().error(e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
