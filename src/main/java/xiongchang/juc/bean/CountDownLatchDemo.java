package xiongchang.juc.bean;

import java.util.concurrent.CountDownLatch;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/2    22:45
 */
public class CountDownLatchDemo  implements  Runnable {

    private CountDownLatch countDownLatch;

    public CountDownLatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i%2==0) {
                        System.out.println(i);
                    }
                }
            }finally {

                countDownLatch.countDown();
            }
        }

    }
}
