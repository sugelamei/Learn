package xiongchang.jdk8.main;


import xiongchang.jdk8.bean.Cal;
import xiongchang.jdk8.bean.LambdaDemo;
import xiongchang.jdk8.bean.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
  1.lambda表达式的基础语法 ：java8 中引入的一个新的操作符，"->",该操作符称为箭头操作符或者Lambda操作符，
                            箭头操作符将Lambda表达式拆分成2个部分：
                            左侧：Lambda  表达式的参数列表
                            右侧：表达式中所需执行的功能，即Lambda体

                            语法格式一：无参数，无返回值
                            （）->System.out.println()
                            语法格式二：有一个参数，无返回值
                            （x）->(x)-> System.out.println(x);
                            语法格式三：有一个参数，无返回值，小括号可以不写
                            x-> System.out.println(x)
                            语法格式四：有2个参数，有返回值，并且Lambda体有多条语句，需要
                             Comparator<Integer> comparator  = (x, y)->{
                             System.out.println("x+y");
                             return Integer.compare(x,y);
                             };
                             语法格式五：有2个参数，有返回值，并且Lambda体有一条语句，return 和大括号可以不写
                             Comparator<Integer> comparator  = (x, y)-> Integer.compare(x,y);
                            语法格式五：有Lambda表达式的参数列表的参数类型可以不写，因为JVM编译器通过上下文推断出数据类型,即"类型推断"
                            (Integer x,Integer  y)->Integer.compare(x,y);

                            上联：左右遇一括号省
                            下联：左侧推断类型省
                            横批：能省则省

 2.Lambda表达式需要“函数式接口”的支持
     函数式接口：接口中只要一个抽象方法，称为函数式接口，可以使用  @FunctionalInterface 修饰
                  可以检查是否是函数式接口；
 */

public class TestLambda {

    public static void main(String[] args) {
         List<LambdaDemo> lambdaDemos  = Arrays.asList(
                 new LambdaDemo(18,9999.99,"wxc1"),
                 new LambdaDemo(28,8888.88,"wxc2"),
                 new LambdaDemo(38,7777.77,"wxc3"),
                 new LambdaDemo(48,6666.66,"wxc4"),
                 new LambdaDemo(58,5555.55,"wxc5")
                 );

        List<LambdaDemo> demos = filterLambda(lambdaDemos, new Predicate<LambdaDemo>() {
            @Override
            public Boolean filt(LambdaDemo lambdaDemo) {
                return lambdaDemo.getAge() > 18;
            }
        });

        for (LambdaDemo demo : demos) {
            System.out.println(demo);
        }


        System.out.println("--------------------------------------");

        List<LambdaDemo> lambdaDemoList  = filterLambda(lambdaDemos,(e)->e.getSalary()>7000.0);

        lambdaDemoList.forEach(lambdaDemo -> System.out.println(lambdaDemo));

        System.out.println("----------------------------------------------");
        lambdaDemoList.forEach(System.out::println);

        System.out.println("----------------------------------------------");
        //优化方式四
        lambdaDemos.stream().filter((e)->e.getSalary()>7000).limit(1).forEach(System.out::println);

        System.out.println("----------------------------------------------");

        int num = 0;//jdk 1.7 ,在内部类中的局部变量必须用final  jdk1.8不需要写
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello"+num);
            }
        }).start();

        System.out.println("----------------------------------------------");
        Runnable r =()-> System.out.println("hello  lambda");
        r.run();


        Consumer<String> consumer =(x)-> System.out.println(x);
        consumer.accept("hello  aaa");
        Consumer<String> consumer1 =x-> System.out.println(x);
        consumer.accept("hello  aaa");

        Comparator<Integer> comparator  = (x, y)->{
            System.out.println("x+y");
            return Integer.compare(x,y);
        };
        System.out.println(comparator.compare(1, 2));


        System.out.println("cal------------------------");

        System.out.println(opera(100, (x) -> x*x));


    }


  public static List<LambdaDemo>  filterLambda(List<LambdaDemo> list,Predicate<LambdaDemo> predicate){
      List<LambdaDemo> lambdaDemos  = new ArrayList<>();

      for (LambdaDemo demo : list) {
          if (predicate.filt(demo)) {
              lambdaDemos.add(demo);
          }
      }
      return  lambdaDemos;
    }

 //需求：对一个数进行计算

    public  static  Integer opera(Integer num, Cal cal){
        return cal.cal(num);
    }
}
