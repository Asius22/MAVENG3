package utils;

import utils.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * prodotto
 * marca tipo modello costo
 *
 * lettura dati file
 */
public class Readproperties {
    private static final Log l = Log.getInstance();
    private String resourceNam;
    private Properties prop;
    private InputStream input;
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    /**
     * @param prop
     * @param input
     */
    public Readproperties(Properties prop, InputStream input, String resourceName) {
        this.prop = prop;
        this.input = input;
        this.resourceNam = resourceName;
    }

    public Readproperties() throws IOException {
        init();
    }

    public Readproperties(String resourceNam) throws IOException {
        this.resourceNam = resourceNam;
        init();
    }

    /**
     *
     * @throws IOException
     */
    public void init() throws IOException{
        this.prop = new Properties();
        input = new FileInputStream(
                "src\\main\\resources\\" + ((this.resourceNam == null) ? "application.properties" : this.resourceNam)
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
