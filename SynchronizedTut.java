/**
 * Created by ravikumar.t on 24/06/15.
 */
public class SynchronizedTut {
    private int count=0;
    public void increment() {
        count++;
        System.out.println(count+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        SynchronizedTut xc = new SynchronizedTut();
        xc.wrk();

    }

    public void wrk(){
        Thread a = new Thread(new Runnable(){
            public void run(){
                for (int j=0;j<100000;j++){
                    increment();
                }
            }
        });

        Thread b = new Thread(new Runnable(){
            public void run(){
                for (int j=0;j<100000;j++){
                    increment();
                }
            }
        });
        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(count);

    }
}
