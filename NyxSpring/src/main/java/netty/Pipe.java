package netty;


import java.util.Iterator;
import java.util.Map;

public class Pipe implements IPipe {

    public Iterator<Map.Entry<String, Object>> iterator() {
        return null;
    }

    public static void main(String[] args) {
        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println(cpu);
        long m = Runtime.getRuntime().maxMemory();
        System.out.println(m/1024/1024);


    }
}
