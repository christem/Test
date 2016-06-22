package demo.base.c17Socket.s3.SimpleAIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

public class SimpleAIOClient {
    static final int PORT = 30000;

    public static void main(String[] args) throws Exception {
	// 用于读取数据的ByteBuffer。
	ByteBuffer buff = ByteBuffer.allocate(1024);
	Charset utf = Charset.forName("utf-8");
	// ①创建AsynchronousSocketChannel对象
	try (AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open()) {
	    // ②连接远程服务器
	    clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get(); // ④
	    buff.clear();
	    // ③从clientChannel中读取数据
	    clientChannel.read(buff).get(); // ⑤
	    buff.flip();
	    // 将buff中内容转换为字符串
	    String content = utf.decode(buff).toString();
	    System.out.println("服务器信息：" + content);

	    clientChannel.write(ByteBuffer.wrap("欢迎你来自AIO的世界-客户端！".getBytes("UTF-8"))).get();
	}
    }
}
