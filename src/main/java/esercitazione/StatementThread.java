package esercitazione;

import db.Log;

import java.sql.PreparedStatement;
import java.sql.Statement;

public abstract class StatementThread implements Runnable{
    protected PreparedStatement stat;
    protected static final Log L = Log.getInstance();
    protected StatementThread(PreparedStatement stat){
        this.stat = stat;
    }

}
