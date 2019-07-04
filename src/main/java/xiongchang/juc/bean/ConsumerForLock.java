package xiongchang.juc.bean;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    20:36
 */
public class ConsumerForLock implements Runnable {

    private  ClerkForLock clerk;

    public ConsumerForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            clerk.sale();
        }

    }
}


