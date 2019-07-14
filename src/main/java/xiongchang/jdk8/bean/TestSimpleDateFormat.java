package xiongchang.jdk8.bean;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //return simpleDateFormat.parse("20190713");
                return LocalThreadDate.covert("20190713");
            }
        };


        List<Future<Date>> list  = new ArrayList<>();
        ExecutorService executorService  = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {

            list.add(  executorService.submit(task));
        }

        for (Future<Date> future : list) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
