package xiongchang.juc.bean;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    21:35
 */
public class AlternateDemo {
    private  int  number = 1;

    private Lock lock = new ReentrantLock();


    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();



    public  void  loopA(){
        lock.lock();
        try {
            if (number!=1){
                condition1.await();
            }
            for (int i = 0; i < 1; i++) {

                System.out.println(Thread.currentThread().getName());
            }
            number =2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



    public  void  loopB(){
        lock.lock();
        try {
            if (number!=2){

                condition2.await();
            }
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public  void  loopC(){
        lock.lock();
        try {
            if (number!=3){
                condition3.await();
            }
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
