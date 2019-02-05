package annotationSpring;


import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope("singleton")
@Component
@Inherited
public @interface SingletonComponent {
    @AliasFor(annotation = Component.class, attribute = "value")
    String value() default "";

    String desc() default "kk";

}
