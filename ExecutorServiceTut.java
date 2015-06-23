import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ravikumar.t on 20/01/15.
 */
public class ExecutorServiceTut {
    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Blocks main thread till execution is completed.
        }
        System.out.println("Execution finished");
    }
}

class WorkerThread implements Runnable {
    private String message;
    public WorkerThread(String s){
        this.message=s;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+" START::: message = "+message);
        processmessage();
        System.out.println(Thread.currentThread().getName()+" END:::");
    }
    private void processmessage() {
        try {  Thread.sleep(200);  } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
