import java.util.concurrent.TimeUnit;

public class ThreadTest {

    static Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("start...");

        new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    System.out.println("before...");
                    try {
                        lock.wait();
                    }catch (Exception e){

                    }
                    System.out.println("after...");

                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("before notify...");
                    lock.notify();
                    System.out.println("after notify...");
                }catch (Exception e){

                }}
            }
        }).start();


    }
}
