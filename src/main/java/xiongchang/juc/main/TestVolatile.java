package xiongchang.juc.main;

import xiongchang.juc.bean.ThreadDemo;

import java.util.zip.DeflaterOutputStream;

/**
 * 1.内存可见性问题可以使用volatile和synchronized解决 但是synchronized执行效率会降低
 * 2.volatile 不能重排序  比加锁执行效率低
 * 3.相较于synchronized 较为轻量级的同步策略
 * 注意：
 * 1.volatile不具备互斥性
 * 2.volatile不能保证原子性
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();

        Integer i = 0;
         while (i<10){
             synchronized (threadDemo){
                 if (threadDemo.getFlag()) {
                     System.out.println("++++++++++++++++++++++=i"+i);
                     i++;
                 }
             }
         }

    ThreadDemo threadDemo1 = new ThreadDemo();
        new Thread(threadDemo1).start();

        Integer i1 = 0;
        while (i < 10) {
            if (threadDemo1.getFlag()) {
                System.out.println("++++++++++++++++++++++=i1" + i1);
                i1++;
            }
        }

    }
}