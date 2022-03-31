package thread;

import utils.Log;

public class NumberPrintRunnable implements Runnable{

    private int min, max;
    private static final Log l = Log.getInstance();

    public NumberPrintRunnable(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        print();
    }

    private void print(){
        l.info("min: " + min);
        l.info("max: " + max);
    }

    public static void main(String[] args) throws InterruptedException {
        NumberPrintRunnable nr = new NumberPrintRunnable(2,4);

        Thread t = new Thread(nr);
        t.join();
        t.start();

        l.info("DONE!");
    }
}
