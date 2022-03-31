package esercitazione2;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * CREATE TABLE IF EXISTS AUTO( id int not null auto_increment, marchio varchar(30) not null, nazione varchar(30) not null, fatturato int not null, dipendenti int not null, primary key(id));
 * <p>
 * elenca marchio e fatturato in ordine discendente
 * elenca numero marchi per nazione
 * dipendenti per nazione
 * per ogni marchio elenca il fatturato in ordine descresceente
 * fatturato per nazione in ordine decrescente
 * query per id
 * delete record
 */
public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        String create = "CREATE TABLE IF NOT EXISTS AUTO( " +
                "id int not null auto_increment, " +
                "marchio varchar(30) not null, " +
                "nazione varchar(30) not null, " +
                "fatturato int not null, " +
                "dipendenti int not null, " +
                "primary key(id));";
        String deleteQuery = "DELETE FROM AUTO WHERE id = ?";
        Scanner scan = new Scanner(System.in);
        StatementThread esecuzione = null;
        String scelta = "";
        while (!scelta.equals("exit")) {
            System.out.println("Quale operazione vuoi effetuare?");
            scelta = scan.nextLine();

            switch (scelta.toLowerCase()) {
                case "create" -> esecuzione = new CreateThread(create);
                case "insert" -> esecuzione = insert();
                case "select" -> esecuzione = select();
                case "delete" -> esecuzione = new DeleteThread(deleteQuery, 1);
            }

            Thread t = new Thread(esecuzione);
            t.start();
            t.join();
        }
        esecuzione.closeAll();
    }

    private static StatementThread insert() {
        String insertQuery = "INSERT INTO AUTO (marchio, nazione, fatturato, dipendenti) values (?,?,?,?)";
        String marchio, nazione;
        int fatturato, dipendenti;
        Scanner scan = new Scanner(System.in);

        System.out.println("marchio: ");
        marchio = scan.nextLine();
        System.out.println("nazione: ");
        nazione = scan.nextLine();
        System.out.println("fatturato: ");
        fatturato = scan.nextInt();
        System.out.println("dipendenti: ");
        dipendenti = scan.nextInt();

        return new InsertThread(insertQuery, marchio, nazione, fatturato, dipendenti);
    }

    private static StatementThread select() {
        String uno = "SELECT nazione, sum(dipendenti) FROM AUTO GROUP BY nazione",
                due = "SELECT marchio, fatturato FROM AUTO GROUP BY marchio ORDER BY fatturato DESC",
                tre = "SELECT nazione, count(DISTINCT marchio) FROM AUTO GROUP BY nazione",
                quattro = "SELECT nazione, sum(fatturato) FROM AUTO group by nazione ";

        String selected = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Quale select vuoi eseguire?");
        System.out.println("1)dipendenti per nazione\n" +
                "2) marchio e fatturato\n" +
                "3) numero marchi per nazione\n" +
                "4) fatturato per nazione\n");
        switch (scan.nextInt()) {
            case 1 -> selected = uno;
            case 2 -> selected = due;
            case 3 -> selected = tre;
            case 4 -> selected = quattro;
            default -> selected = "";
        }
        return new SelectThread(selected);
    }
}
