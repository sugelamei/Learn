package xiongchang.juc.main;

import xiongchang.juc.bean.CallablDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1.创建执行线程的方式三：实现callable接口
 * 2.Callable 和Runnable的区别
 *  Callable 方法有返回值 并且抛出异常
 *  执行callable方式需要FutureTask<V>   实现类的之后 接收运算结果  是Future的实现类
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallablDemo  callablDemo  =  new CallablDemo();
        //执行callable方式需要FutureTask<V>   实现类的之后 接收运算结果  是Future的实现类
        FutureTask<Integer> futureTask  = new FutureTask<>(callablDemo);
        new  Thread(futureTask).start();


        //接收线程运算后的结果
        //FutureTask 也可以用于闭锁
        System.out.println(futureTask.get());
        System.out.println("------------------------------");
    }
}
