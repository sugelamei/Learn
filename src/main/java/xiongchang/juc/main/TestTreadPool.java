package xiongchang.juc.main;

import xiongchang.juc.bean.TreadPoolDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/4    20:54
 */
public class TestTreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
/*
        for (int i = 0; i < 10; i++) {
            TreadPoolDemo demo = new TreadPoolDemo();
            //为线程分配任务
            pool.submit(demo);
        }*/


        List<Future<Integer>>  list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> submit = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Integer num = 0;
                    for (int i = 0; i < 10; i++) {
                        num += i;
                    }

                    return  num;
                }
            });
            list.add(submit);
        }
        /*Future<Integer> submit = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer num = 0;
                for (int i = 0; i < 10; i++) {
                    num += i;
                }

                return  num;
            }
        });*/

        for (Future<Integer> submit : list) {
            System.out.println(submit.get());

        }



        //关闭线程池
        pool.shutdown();

    }


}
