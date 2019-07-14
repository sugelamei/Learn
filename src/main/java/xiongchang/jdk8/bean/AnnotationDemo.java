package xiongchang.jdk8.bean;

import org.junit.runner.RunWith;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Repeatable(AnnotationDemos.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {

    String value() default  "wxc";

}
