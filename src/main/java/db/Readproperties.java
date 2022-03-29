package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * prodotto
 * marca tipo modello costo
 *
 * lettura dati file
 */
public class Readproperties {
    private static final Log l = Log.getInstance();
    private static final String resourceName = "application.properties";
    private Properties prop;
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

    public Readproperties() throws IOException {
        init();
    }

    /**
     *
     * @throws IOException
     */
    public void init() throws IOException{
        this.prop = new Properties();
        input = new FileInputStream(
                "src\\main\\resources\\" + resourceName
        );
        this.prop.load(input);
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public InputStream getInput() {
        return input;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }
}
