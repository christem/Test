package demo.base.c17Socket.s3.AIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {
    static final int PORT = 30000;
    final static String UTF_8 = "utf-8";
    static List<AsynchronousSocketChannel> channelList = new ArrayList();

    public static void main(String[] args) throws Exception {
	AIOServer server = new AIOServer();
	server.startListen();
    }

    public void startListen() throws InterruptedException, Exception {
	// ����һ���̳߳�
	ExecutorService executor = Executors.newFixedThreadPool(20);
	// ��ָ���̳߳�������һ��AsynchronousChannelGroup
	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
	// ��ָ���̳߳�������һ��AsynchronousServerSocketChannel
	AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(channelGroup)
	// ָ������������PORT�˿�
	        .bind(new InetSocketAddress(PORT));
	// ʹ��CompletionHandler�������Կͻ��˵���������
	serverChannel.accept(null, new ServerAcceptHandler(serverChannel)); // ��
    }

}

// ʵ���Լ���CompletionHandler��
class ServerAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    private AsynchronousServerSocketChannel serverChannel;

    public ServerAcceptHandler(AsynchronousServerSocketChannel sc) {
	this.serverChannel = sc;
    }

    // ����һ��ByteBuffer׼����ȡ����
    ByteBuffer buff = ByteBuffer.allocate(1024);

    // ��ʵ��IO�������ʱ�򴥷��÷���
    public void completed(final AsynchronousSocketChannel sc, Object attachment) {
	// ��¼�����ӵĽ�����Channel
	AIOServer.channelList.add(sc);
	// ׼�����ܿͻ��˵���һ������
	serverChannel.accept(null, this);
	sc.read(buff, null, new CompletionHandler<Integer, Object>() // ��
	        {
		    public void completed(Integer result, Object attachment) {
		        buff.flip();
		        // ��buff������ת��Ϊ�ַ���
		        String content = StandardCharsets.UTF_8.decode(buff).toString();
		        // ����ÿ��Channel�����յ�����Ϣд���Channel��
		        for (AsynchronousSocketChannel c : AIOServer.channelList) {
			    try {
			        c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
		        }
		        buff.clear();
		        // ��ȡ��һ������
		        sc.read(buff, null, this);
		    }

		    public void failed(Throwable ex, Object attachment) {
		        System.out.println("��ȡ����ʧ��: " + ex);
		        // �Ӹ�Channel��ȡ����ʧ�ܣ��ͽ���Channelɾ��
		        AIOServer.channelList.remove(sc);
		    }
	        });
    }

    /**
     * ��IO����ʧ�ܵ�ʱ�����ķ����� ��һ��������ʾIO����ʧ�������Ĵ�����쳣 �ڶ���������ʾIO��������ʱ����ĸ��Ӳ���
     */
    public void failed(Throwable ex, Object attachment) {
	System.out.println("����ʧ��: " + ex);
    }
}