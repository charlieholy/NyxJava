package junit;

/**
 * Created by chenpeiwen on 2019/1/28
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Junit {
    //传入一个对象实例
    public static void run(Class c) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        //获取对象声明的方法集合
        Method[] methods = c.getDeclaredMethods();
        //@Test注解的方法集合
        List<Method> testList = new ArrayList<Method>();
        //@After注解方法
        Method afterMethod = null;
        //@Before的注解方法
        Method beforeMethod = null;
        //循环对象声明的所有方法
        for (Method method : methods) {
            //如果有@Test注解，则将该方法加入到Test注解的方法集合
            if (method.isAnnotationPresent(Test.class)) {
                testList.add(method);
            }
            //如果有@Before注解，则引用该方法
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethod = method;
            }
            //如果有@After注解，则引用该方法
            if (method.isAnnotationPresent(After.class)) {
                afterMethod = method;

            }

        }
        //new一个对象实例
        Object obj = c.newInstance();
        //反射激活方法
        for (Method m : testList) {
            if (beforeMethod != null) {
                beforeMethod.invoke(obj, null);
            }

            m.invoke(obj, null);
            if (afterMethod != null) {
                afterMethod.invoke(obj, null);
            }

        }

    }
}