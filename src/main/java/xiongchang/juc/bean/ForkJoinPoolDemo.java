package xiongchang.juc.bean;

import java.util.concurrent.RecursiveTask;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/4    21:45
 */
public class ForkJoinPoolDemo extends RecursiveTask<Long> {


    private static  final  Long  LONG = 10000000L;

    private Long start;


    private Long end;


    public ForkJoinPoolDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }



    @Override
    protected Long compute() {

        Long lenth = end -start;

        if (lenth<=LONG){
            Long  sum = 0L;

            for (Long i = start; i <=end ; i++) {
                sum+=i;
            }

            return  sum;
        }else  {
            Long mid  = (start+end)/2;
            ForkJoinPoolDemo left = new ForkJoinPoolDemo(start, mid);
            left.fork();
            ForkJoinPoolDemo right = new ForkJoinPoolDemo(mid+1, end);
            right.fork();

            return  left.join()+right.join();

        }

    }
}
