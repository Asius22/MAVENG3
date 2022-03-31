package esercitazione;

import utils.Log;

import java.sql.PreparedStatement;

public abstract class StatementThread implements Runnable{
    protected PreparedStatement stat;
    protected static final Log L = Log.getInstance();
    protected StatementThread(PreparedStatement stat){
        this.stat = stat;
    }

}
