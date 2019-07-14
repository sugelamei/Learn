package xiongchang.jdk8.bean;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author love
 */
public class ForkJionDemo extends RecursiveTask<Long> {

    private Long start;

    private Long end;

    public ForkJionDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    private final static Long LONG = 100000L;

    @Override
    protected Long compute() {
        Long  lenth   = start - end;

        if (lenth<=LONG){
            Long sum   = 0L;
            for (long i = start; i <= end; i++) {
                sum +=i;
            }

            return  sum;
        }else {
            Long  mid  = (start+end)/2;
            ForkJionDemo left  =  new ForkJionDemo(start,mid);
            left.fork();
            ForkJionDemo right  = new ForkJionDemo(mid,end);
            right.fork();
            return left.join() +right.join();
        }
    }


    public static void main(String[] args) {


        Long  END   = 10000000000L;
       /* Instant start   = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJionDemo forkJionDemo   = new ForkJionDemo(0L,END);
        System.out.println(pool.invoke(forkJionDemo));
        Instant end   = Instant.now();

        System.out.println(Duration.between(start, end).toMillis());
        System.out.println("-----------------------------------------");*/

       /* Instant start1   = Instant.now();
        Long sum  = 0L;
        for (long i = 0; i <= END; i++) {
            sum+=i;
        }

        System.out.println(sum);
        Instant end1   = Instant.now();
        System.out.println(Duration.between(start1, end1).toMillis());
        System.out.println("-----------------------------------------");*/

        Instant start2   = Instant.now();

        //Long sum1  = LongStream.rangeClosed(0L,END).parallel().sum();
        Long  sum1 =LongStream.rangeClosed(0L,END).sequential().reduce(0,Long::sum);
        System.out.println(sum1);

        Instant end2   = Instant.now();
        System.out.println(Duration.between(start2, end2).toMillis());
    }
}
