package xiongchang.juc.main;


import xiongchang.juc.bean.*;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    20:42
 */
public class TestProductorAndConsumerForLock {
    public static void main(String[] args) {
        ClerkForLock forLock  = new ClerkForLock();
        ProductorForLock productor  = new ProductorForLock(forLock);
        ConsumerForLock consumer = new ConsumerForLock(forLock);

        new  Thread(productor,"生产者A").start();
        new  Thread(productor,"生产者B").start();
        new Thread(consumer,"消费者A").start();
        new Thread(consumer,"消费者B").start();
    }
}
