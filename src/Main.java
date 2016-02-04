import java.util.ArrayList;

/**
 * Created by k3rnel on 4/2/16.
 */
public class Main {

    public static void main(String [] args){

        PrintQueue printQueue = new PrintQueue();
        ArrayList<Thread> printerThreads = new ArrayList<>();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                printQueue.printJob("Documento");
            }
        };

        Thread t;

        for (int i = 0; i < 10; i++){
            t = new Thread(r);

            printerThreads.add(t);

            t.start();
        }

        for (Thread printerThread: printerThreads) {
            try {
                printerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
