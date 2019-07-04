package xiongchang.juc.main;

import xiongchang.juc.bean.ForkJoinPoolDemo;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/4    21:45
 */
public class TestForkJoinPool {

    public static void main(String[] args) {
        Instant start  = Instant.now();
        /*ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long>  task= new ForkJoinPoolDemo(0L,10000000L);//211

        Long invoke = pool.invoke(task);
        System.out.println(invoke);*/

        //java 8  新特性
        Long sum = LongStream.rangeClosed(0L,100000000000L)
                              .parallel()
                                .reduce(0L,Long::sum);

        Instant  end =  Instant.now();
        System.out.println(sum); //193

        System.out.println(Duration.between(start,end).toMillis());


        //pool.shutdown();



    }
}
