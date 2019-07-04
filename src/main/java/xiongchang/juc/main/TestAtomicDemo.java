package xiongchang.juc.main;

import xiongchang.juc.bean.AtomicDemo;

/**
 * 原子性问题：
 * int i= 10;
 * i= i++;//10
 *
 * int t = i;
 * i= i+1;
 * i=t;
 *
 *
 * 二:原子变量 jdk 中提供了atomic包
 *    1.volatile   保证内存可见性
 *    2.CAS （Compare-And-Swap）  算法保证数据的原子性
 *    CAS 包括三个操作数：
 *    内存值 V
 *    预估值 A
 *    更新值 B
 *    当且仅当V==A 时，V=B，否则不做任何操作
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();

        }

    }

}
