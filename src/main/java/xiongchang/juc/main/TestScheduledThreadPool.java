package xiongchang.juc.main;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/4    21:34
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            ScheduledFuture<Double> future = pool.schedule(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    Double num = Math.random() * 101;
                    System.out.println(Thread.currentThread().getName()+"===>" + num);
                    return num;
                }
            }, 1, TimeUnit.SECONDS);

            System.out.println(future.get());
        }

       pool.shutdown();
    }
}
