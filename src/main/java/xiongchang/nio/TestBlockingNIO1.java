package xiongchang.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO1 {
    @Test
    public void  client() throws IOException {
        SocketChannel socketChannel =  SocketChannel.open(new InetSocketAddress("127.0.0.1",9595));
        FileChannel fileChannel  =  FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
        ByteBuffer byteBuffer  = ByteBuffer.allocate(1024);

        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.shutdownOutput();
        Integer len = null;
        while ((len=socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(),0,len));
            byteBuffer.clear();

        }



        fileChannel.close();
        socketChannel.close();
    }

    @Test
    public  void  server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel fileChannel =  FileChannel.open(Paths.get("3.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        serverSocketChannel.bind(new InetSocketAddress(9595));

        SocketChannel socketChannel = serverSocketChannel.accept();
        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }


        buffer.put("成功".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        socketChannel.close();
        fileChannel.close();
        serverSocketChannel.close();


    }

    public static void main(String[] args) throws IOException {
        TestNonBlockingNIO testNonBlockingNIO  = new TestNonBlockingNIO();
        testNonBlockingNIO.client();
    }
}
