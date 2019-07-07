package xiongchang.jdk8.bean;

import java.io.PrintStream;
import java.util.function.Consumer;

/*
方法引用：若Lanbda 体中的内容已经实现了，我们可以使用“方法引用”
         主要有三种语法格式：
         对象::实例方法名
         类::静态方法名
         类::实例方法名
 */
public class MethodRefDemo {
    public static void main(String[] args) {
        Consumer<Integer> consumer  = (x)-> System.out.println(x);

        PrintStream out = System.out;
        Consumer<Integer> consumer1  = out::println;
        consumer.accept(1211);
        consumer1.accept(1651651); 
    }
}
