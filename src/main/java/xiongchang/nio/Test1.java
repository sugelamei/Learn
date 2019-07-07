package xiongchang.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Scanner;

public class Test1 {

    @Test
    public  void  test() throws IOException {
        Pipe pipe = Pipe.open();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sink = pipe.sink();
        Scanner scanner = new Scanner(System.in);

            buffer.put(("sink===>"+scanner.next()).getBytes());
            buffer.flip();
            sink.write(buffer);




        Pipe.SourceChannel source = pipe.source();
        buffer.flip();
        source.read(buffer);

        System.out.println("=====>");
        System.out.println(new String(buffer.array(), 0, buffer.limit()));

        sink.close();
        source.close();
    }
}
