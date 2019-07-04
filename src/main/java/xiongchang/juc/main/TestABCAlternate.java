package xiongchang.juc.main;

import xiongchang.juc.bean.AlternateDemo;


/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/3    21:27
 */
public class TestABCAlternate {


    public static void main(String[] args) {

         AlternateDemo alternateDemo  = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternateDemo.loopA();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    alternateDemo.loopB();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    alternateDemo.loopC();
                }
            }
        },"C").start();

    }




}
