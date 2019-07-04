package xiongchang.juc.bean;

/**
 * 1.线程的创建方式四：线程池  提供一个线程队列，队列中保存着所有等待的线程，避免创建与销毁线程的额外的开销，提高响应速度。
 * 2.线程池的体系结构：
 *   java.util.concurrent.Executor:f负责线程的使用与调度的根接口
 *       |--ExecutorService 子接口：线程池的主要接口
 *          |--ThreadPoolExecutor 线程池实现类
 *          |--ScheduledExecutorService    子接口：负责线程的调度
 *          |--ScheduledThreadPoolExecutor  继承了ThreadPoolExecutor  ，实现了ScheduledExecutorService
 *
 * 3.工具类 Executors
 *     ExecutorService  newCachedThreadPool()  缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量
 *     ExecutorService  newFixedThreadPool()   创建固定大小的线程池
 *     ExecutorService  newSingleThreadExecutor()  创建只有一个线程的线程池
 *
 *     ScheduledExecutorService  newScheduledThreadPool（）创建固定大小的线程池，可以延迟或定时的执行任务
 *
 *
 */
public class TreadPoolDemo  implements  Runnable{

  private   int  num = 0;

    @Override
    public void run() {

      System.out.println(Thread.currentThread().getName()+       "===>"+num);


    }
}
