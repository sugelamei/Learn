package xiongchang.juc.bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  解决多线程安全问题的方式：
 * 1.同步代码块
 * 2.同步方法
 * 3.同步锁 Lock
 *    注意：是一个显示锁，需要lock() 上锁，unlock() 释放锁
 */
public class LockDemo  implements  Runnable{

    private  int tick = 100;

    private Lock lock =  new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try {

            while (tick>0){
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName()+"完成售票，余票为："+ --tick);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
              lock.unlock();
        }

    }
}
