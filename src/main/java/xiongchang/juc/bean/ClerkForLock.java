package xiongchang.juc.bean;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    21:07
 */
public class ClerkForLock {
    private  int  product;

    private Lock lock = new ReentrantLock();
    private Condition   condition  = lock.newCondition();


    public  void  get() {

        lock.lock();
        try {
            while (product>=1){
                System.out.println("产品已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +"====>" + ++product);
            condition.signalAll();

        }finally {
            lock.unlock();
        }



    }


    public   void  sale()  {
        lock.lock();
        try {
            while (product<=0){ //为了避免虚假唤醒问题 应该总是使用在循环中
                System.out.println("缺货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +"====>" + --product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }



    }
}
