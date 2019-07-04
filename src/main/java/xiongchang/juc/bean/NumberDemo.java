package xiongchang.juc.bean;

/**
 * 1.2个普通同步方法，两个线程，标准打印, 打印？ //one two
 * 2.新增Thread.sleep（）给getOne() ,打印？  // one two
 * 3.新增普通方法，getThree（），打印？ // three one two
 * 4.2个线程，2个对象，打印？ // two  one
 * 5.修改getOne()为静态同步方法，打印 ？ // two one
 * 6.修改2个方法为静态同步方法，打印？//one two
 * 7.一个静态同步方法，一个非静态同步方法，2个对象，打印？//two one
 * 8.2个均为静态同步方法，2个对象，打印？// one two
 *
 * 线程八锁的关键：
 *   1.非静态的锁默认为this，静态方法的锁对应为对应的Class 实例
 *   2.某一个时刻内，只有一个线程持有锁，无论几个方法
 *   3.this 锁和class锁不是一个锁
 *
 * */
public class NumberDemo {

    public static  synchronized void   getOne()  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static  synchronized void   getTwo(){
        System.out.println("two");
    }

    public  void   getThere(){
        System.out.println("there");
    }
}
