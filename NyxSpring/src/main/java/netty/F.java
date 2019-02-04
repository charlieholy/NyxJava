package netty;

import com.alibaba.fastjson.JSON;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class F implements ThreadFactory {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name ;



    public static void main(String[] args) {
        F f = new F();
        f.setName("sd");
        f.newThread(new Runnable() {
            public void run() {
                while (true){
                //System.out.println("a");
                    String name = ManagementFactory.getRuntimeMXBean().getName();
                    System.out.println(name);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}
            }
        }).start();
        System.out.println(JSON.toJSONString(f,true));
    }

    public Thread newThread(Runnable r) {
        return new Thread(r,"nani");
    }


}
