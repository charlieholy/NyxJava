import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nani {
    public enum BitOp{
        AND,OX;
        String getName(){
            return name();
        }

    }

    public static void main(String[] args) {

        List<String> ss = new ArrayList<>();
        ss.add("a");
        ss.add("b");
        ss.add("a");
        Set<String> sss = new HashSet<>(ss);
        System.out.println(sss.size());
    }
}
