package xiongchang.juc.bean;

/**
 * @Title:
 * @Description:
 * @Author: wangxiongchang
 * @Version:
 * @created 2019/7/1    22:43
 */
public class CompareAndSwap {
    private  int value;


    //获取内存值
    public  synchronized  int getValue(){
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int execptValue,int newValue){

        int oldValue   = value;
        if (oldValue==execptValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    //设置
    public synchronized  boolean compareAndSet(int execptValue,int newValue){
        return execptValue==compareAndSwap(execptValue,newValue);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
