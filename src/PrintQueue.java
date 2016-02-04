import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by k3rnel on 4/2/16.
 */
public class PrintQueue {

    private Lock lockPrinter = new ReentrantLock();

    public PrintQueue(){

    }

    public void printJob(Object document){
        System.out.println("Intento imprimir un documento");
        lockPrinter.lock();

        try {
            System.out.println("Voy a imprimir un documento");
            long randomNumber = (long)(Math.random() * 4000);
            System.out.println("Me va a costar: " + randomNumber);
            Thread.sleep(randomNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockPrinter.unlock();
    }
}
