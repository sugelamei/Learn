package xiongchang.juc.main;

import xiongchang.juc.bean.NumberDemo;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/4    20:30
 */
public class TestThread8Lock {

    public static void main(String[] args) {
        NumberDemo  demo = new NumberDemo();

        NumberDemo demo1  = new NumberDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.getTwo();
            }
        }).start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                demo.getThere();
            }
        }).start();*/
    }
}
