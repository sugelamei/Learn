package xiongchang.juc.main;

import xiongchang.juc.bean.LockDemo;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/2    23:20
 */
public class TestLock  {
    public static void main(String[] args) {
        LockDemo lockDemo  = new LockDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(lockDemo,i+"号窗口").start();
            System.out.println(i);
        }
        /*new Thread(lockDemo,"3号窗口").start();
        new Thread(lockDemo,"4号窗口").start();
        new Thread(lockDemo,"2号窗口").start();
        new Thread(lockDemo,"5号窗口").start();
        new Thread(lockDemo,"6号窗口").start();
*/
    }
}
