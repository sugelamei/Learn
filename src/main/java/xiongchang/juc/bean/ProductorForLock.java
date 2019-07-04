package xiongchang.juc.bean;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    20:35
 */
public class ProductorForLock implements  Runnable {


    private  ClerkForLock clerk;

    public ProductorForLock(ClerkForLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 200; i++) {
            clerk.get();
        }

    }
}
