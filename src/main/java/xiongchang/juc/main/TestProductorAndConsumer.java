package xiongchang.juc.main;

import xiongchang.juc.bean.Clerk;
import xiongchang.juc.bean.Consumer;
import xiongchang.juc.bean.Productor;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    20:42
 */
public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk  = new Clerk();
        Productor  productor  = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new  Thread(productor,"生产者A").start();
        new  Thread(productor,"生产者B").start();
        new Thread(consumer,"消费者A").start();
        new Thread(consumer,"消费者B").start();
    }
}
