package thread;

import utils.Log;

public class ThreadRunnerPrinter extends Thread{
    private int min, max;
    private static final Log l = Log.getInstance();

    public ThreadRunnerPrinter(int min, int max){
        this.min = min;
        this.max = max;
    }

    private void print(){
        for (int i = min; i < max; i++)
            l.info(String.valueOf(i));
    }

    @Override
    public void run() {
        super.run();
        print();
    }

}
