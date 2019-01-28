package junit;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by chenpeiwen on 2019/1/28
 */
public class JunitTest {
    public static void main(String args[]) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Junit.run(TestPrductor.class);
    }
}
