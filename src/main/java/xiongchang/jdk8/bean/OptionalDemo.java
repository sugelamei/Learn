package xiongchang.jdk8.bean;

import org.junit.Test;

import java.util.Optional;

public class OptionalDemo {


    @Test
    public void  test1(){
        Optional<LambdaDemo> lambdaDemo = Optional.of(new LambdaDemo());
        LambdaDemo lambdaDemo1 = lambdaDemo.get();
        System.out.println(lambdaDemo1);

    }

    @Test
    public  void  tets2(){
        Optional<Object> o = Optional.of(null);

        System.out.println(o.get());

    }


    @Test
    public void  test3(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
    }

    @Test
    public  void test4(){
        Optional<Object> o = Optional.ofNullable(null);
        if (o.isPresent()) {
            System.out.println(o.get());
        }
    }

}
