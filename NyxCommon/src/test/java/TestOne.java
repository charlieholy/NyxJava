import org.junit.Test;
import utils.Logger;
import utils.WhiteLogUtils;

public class TestOne {
    @Test
    public void foo(){
        Logger.info("asd");
    }

    @Test
    public void foo2(){
        WhiteLogUtils.append("123","sdf");
    }

    @Test
    public void foo3(){
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("1");
            }catch (Exception e){

            }
        }
    }
}
