package xiongchang.juc.bean;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    21:29
 */
public class PrintDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.println(Thread.currentThread().getName()+"====>"+Thread.currentThread().getName());
        }
    }
}
