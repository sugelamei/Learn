package xiongchang.jdk8.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class DataTime8 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> callable  = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20161218",dtf);
            }
        };


        List<Future<LocalDate>> list  = new ArrayList<>();
        ExecutorService executorService  = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {

            list.add(  executorService.submit(callable));
        }

        for (Future<LocalDate> future : list) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
