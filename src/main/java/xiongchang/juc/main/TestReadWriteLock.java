package xiongchang.juc.main;

import xiongchang.juc.bean.ReadWriteLockDemo;

import java.nio.file.Watchable;

/**
 * 1.ReadWriteLock:读写锁
 * 写写/读写 需要互斥
 * 读读 不需要互斥
 */
public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo lockDemo  =  new ReadWriteLockDemo();




        for (int i = 0; i <10; i++) {

           new  Thread(new Runnable() {
                @Override
                public void run() {
                    lockDemo.read();
                }
            },"Read" +i ).start();

            new  Thread(new Runnable() {
                @Override
                public void run() {
                    lockDemo.Write((int) (Math.random()*101));
                }
            },"Write"+i).start();
        }
    }
}
