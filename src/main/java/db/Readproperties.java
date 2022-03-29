package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Readproperties {
    private static final Log l = Log.getInstance();
    private Properties prop;
    private static final String resourceName = "application.properties";
    private InputStream input;
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    /**
     * @param prop
     * @param input
     */
    public Readproperties(Properties prop, InputStream input) {
        this.prop = prop;
        this.input = input;
    }

    public Readproperties(){}

    /**
     *
     */
    public void init() {
        this.prop = new Properties();
    }

    /**
     *
     * @throws IOException
     */
    public void read() throws IOException {
        input = new FileInputStream(
                "src\\main\\resources\\" + resourceName
        );
        this.prop.load(input);
    }

    public static void main(String[] args) {
        Readproperties readproperties = new Readproperties();
        readproperties.init();
        try{
            readproperties.read();

            String user = readproperties.prop.getProperty("db.url");

            System.out.println(user);
        } catch (IOException e){
            e.printStackTrace();
            l.error(e.getMessage());
        }

    }
}
