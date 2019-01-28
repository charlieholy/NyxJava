package junit;

/**
 * Created by chenpeiwen on 2019/1/28
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)//作用域为方法
@Retention(RetentionPolicy.RUNTIME)//注解信息保留到运行时
public @interface Test {

}