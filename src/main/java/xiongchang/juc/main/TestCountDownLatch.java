package xiongchang.juc.main;

import xiongchang.juc.bean.CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：闭锁：在完成某些运算时，只有其他所有线程的运算执行完成，当前运算才继续执行
 * */
public class TestCountDownLatch  {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDownLatchDemo countDownLatchDemo =  new CountDownLatchDemo(countDownLatch);

        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new  Thread(countDownLatchDemo).start();
        }

        countDownLatch.await();
        Long end  = System.currentTimeMillis();

        System.out.println("============================>"+ (end -start));
    }
}
