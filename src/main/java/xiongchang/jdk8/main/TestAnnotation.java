package xiongchang.jdk8.main;

import org.junit.Test;
import xiongchang.jdk8.bean.AnnotationDemo;

import java.lang.reflect.Method;

public class TestAnnotation {

    @AnnotationDemo("hello")
    @AnnotationDemo("wxc")
    @AnnotationDemo("wxc")
    @AnnotationDemo("wxc")
    @AnnotationDemo("wxc")
    public  void  show()  {

    }

    @Test
    public void test() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        AnnotationDemo[] shows = clazz.getMethod("show").getAnnotationsByType(AnnotationDemo.class);
        for (AnnotationDemo show : shows) {
            System.out.println(show.value());
        }
    }
}
