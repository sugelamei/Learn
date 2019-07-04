package xiongchang.juc.bean;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    20:40
 */
public class Clerk {
    private  int  product;

    public synchronized void  get() {
        while (product>=10){
            System.out.println("产品已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println(Thread.currentThread().getName() +"====>" + ++product);
            this.notifyAll();

    }


    public synchronized  void  sale()  {
        while (product<=0){ //为了避免虚假唤醒问题 应该总是使用在循环中
            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println(Thread.currentThread().getName() +"====>" + --product);
            this.notifyAll();

    }
}
