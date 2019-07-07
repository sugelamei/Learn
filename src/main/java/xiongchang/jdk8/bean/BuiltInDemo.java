package xiongchang.jdk8.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
  java8  内置的四大核心接口：
    Consumer<T> :消费接口
                 void accept(T t)

    Supplier<T>  :供给型接口
                 T get()

    Function<T,R>: 函数型接口
                  R apply(T t)

   Predicate<T>:断言型接口
              boolean  test(T t)



 */
public class BuiltInDemo {

    public static void main(String[] args) {
        happpy(1000.0,(m)-> System.out.println(m));
        for (Integer integer : getNumber(10, () -> (int) (Math.random() * 100))) {
            System.out.println(integer);
        }
        getNumber(10, () -> (int) (Math.random() * 100)).forEach(System.out::println);
        System.out.println("_____________________________________________________");
        System.out.println(getSize("asasasasas511a", (x) -> x.length()));

        System.out.println("_____________________________________________________");
        List<Integer> list = Arrays.asList(new  Integer[]{1,2,3,4,5,6,7,8,9,10});
        Compare(list,(x)->x.intValue()>5).forEach(System.out::println);




    }

    //Predicate<T>
     public static List<Integer>  Compare(List<Integer> list, Predicate<Integer> predicate){
         List<Integer> list1  = new ArrayList<>();
         for (Integer integer : list) {
             if (predicate.test(integer)) {
                 list1.add(integer);
             }
         }

         return list1;
     }


    //Consumer<T>
   public static void happpy(Double money,Consumer<Double> consumer){
        consumer.accept(money);
   }

    //Supplier<T>
   public static List<Integer> getNumber(Integer num,Supplier<Integer> supplier){
        List<Integer> list  = new ArrayList<>();
       for (int i = 0; i < num; i++) {
           list.add(supplier.get());
       }
       return list;
   }

   //Function<T,R>
   public static  Integer getSize(String string, Function<String,Integer> function) {
        return  function.apply(string);
   }
}
