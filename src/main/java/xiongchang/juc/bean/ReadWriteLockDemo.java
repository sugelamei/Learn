package xiongchang.juc.bean;

import javax.xml.transform.Source;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    22:20
 */
public class ReadWriteLockDemo {

    private  int   num = 0;
    ReadWriteLock lock   =  new ReentrantReadWriteLock();

    public  void  read(){
        lock.readLock().lock();//上读锁

        try {
            System.out.println(Thread.currentThread().getName()+ "====="+num);

        }finally {
          lock.readLock().unlock();//解除读锁
        }
    }

    public void  Write( int num){


        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+ "====="+num );
            this.num = num;
        }finally {
            lock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName()+ "===finally=="+num );
        }

    }
}
