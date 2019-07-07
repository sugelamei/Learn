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

public class TestBlockingNIO {


    @Test
    public  void  client() throws IOException {
        //1.获取网络通道
        SocketChannel socketChannel = SocketChannel.open( new InetSocketAddress("127.0.0.1",9898));

        //2.创建文件通道
        FileChannel inchannel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
        //3.创建缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);


        //4.将缓冲区中得数据写到通道中
        while (inchannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        //6.关闭通道
        inchannel.close();
        socketChannel.close();

    }
    @Test
    public  void   server() throws IOException {

        //1.获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
       //2.获取文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //3.绑定端口
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //4.创建缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //5.连接客户端的管道
        SocketChannel socketChannel = serverSocketChannel.accept();

        //6.判断管道中是否有东西
        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        //7.关闭通道
        fileChannel.close();
        socketChannel.close();
        serverSocketChannel.close();
    }
}
