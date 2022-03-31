package employer;

import utils.Log;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Log l = Log.getInstance();
        try {
            CommandLine cmd = new CommandLine();
            cmd.start();
        } catch (IOException e){
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
