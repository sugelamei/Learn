package xiongchang.juc.bean;


import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**CopyOnWriteArrayList
 * CopyOnWriteArraySet
 * 1.添加操作时，效率低，每次添加时都会进行复制，开销非常大
 * 2,并发迭代操作多时可以使用
 */
public class CopyOnWriteArrayListDemo implements  Runnable {


    //private static List<String> list = Collections.synchronizedList( new ArrayList<>());

    private  static CopyOnWriteArrayList<String> list  = new CopyOnWriteArrayList<>();
    static {
        list.add("aa");
        list.add("bb");
        list.add("cc");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("AA");
        }

    }
}
