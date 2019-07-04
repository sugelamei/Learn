package xiongchang.juc.main;

import xiongchang.juc.bean.CopyOnWriteArrayListDemo;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/2    22:12
 */
public class TestCopyOnWriteArrayList {



    public static void main(String[] args) {
        CopyOnWriteArrayListDemo copy = new CopyOnWriteArrayListDemo();
        for (int i = 0; i < 10; i++) {
         new  Thread(copy).start();
        }
    }
}

