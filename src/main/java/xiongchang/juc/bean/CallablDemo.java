package xiongchang.juc.bean;

import java.util.concurrent.Callable;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/2    23:03
 */
public class CallablDemo implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        Integer sum  = 0;

        for (int i = 0; i <Integer.MAX_VALUE; i++) {
            sum +=i ;
           // System.out.println(i);
        }
        return sum;
    }
}
