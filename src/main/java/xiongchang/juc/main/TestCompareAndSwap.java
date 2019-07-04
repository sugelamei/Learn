package xiongchang.juc.main;

import com.sun.deploy.panel.CacheSettingsDialog;
import xiongchang.juc.bean.CompareAndSwap;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/1    22:43
 */
public class TestCompareAndSwap {


    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                  int  execptValue  =  cas.getValue();
                    System.out.println(cas.compareAndSet(execptValue, (int) (Math.random() * 101)));
                }
            }).start();
        }
    }
}
