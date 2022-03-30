package db;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log {
    private static final Logger l = Logger.getLogger(Log.class);
    private static Log log = null;

    private Log(){}

    {
        BasicConfigurator.configure();
    }

    public static Log getInstance(){
        if (log == null) synchronized (Log.class){
            log = new Log();
        }
        return log;
    }

    public void error(String parameter){
        l.error(parameter);
    }

    public void warn(String parameter){
        l.warn(parameter);

    }

    public void info(String parameter){
        l.info(parameter);

    }

    public void debug(String parameter){
        l.debug(parameter);
    }
}
