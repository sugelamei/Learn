package xiongchang.juc.bean;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/1    22:08
 */
public class AtomicDemo implements  Runnable {

    private AtomicInteger atomicInteger =new AtomicInteger();

    public Integer getAtomicInteger() {
        return atomicInteger.getAndIncrement();
    }

    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("i===get===>"+getAtomicInteger());
        /*System.out.println("i===getAndAdd===>"+i.getAndAdd(1));
        System.out.println("i===getAndDecrement===>"+i.getAndDecrement());
        System.out.println("i===getAndIncrement===>"+i.getAndIncrement());
        System.out.println("i===getAndSet===>"+i.getAndSet(3));
        System.out.println("i===addAndGet===>"+i.addAndGet(1));
        System.out.println("i===compareAndSet===>"+i.compareAndSet(1,1));*/
    }
}
