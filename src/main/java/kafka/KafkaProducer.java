package kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer extends Thread {
	private final Producer<Integer, String> producer;
	private final String topic;
	private final Properties props = new Properties();

	public KafkaProducer(String topic) {
		// 配置key的序列化类
		// props.put("key.serializer.class", "kafka.serializer.StringEncoder");
		props.put("serializer.class", "kafka.serializer.StringEncoder"); // 配置value的序列化类
		props.put("metadata.broker.list", "localhost:9092");// 此处配置的是kafka的端口

		/**
		 * request.required.acks 0, which means that the producer never waits
		 * for an acknowledgement from the broker (the same behavior as 0.7).
		 * This option provides the lowest latency but the weakest durability
		 * guarantees (some data will be lost when a server fails). 1, which
		 * means that the producer gets an acknowledgement after the leader
		 * replica has received the data. This option provides better durability
		 * as the client waits until the server acknowledges the request as
		 * successful (only messages that were written to the now-dead leader
		 * but not yet replicated will be lost). -1, which means that the
		 * producer gets an acknowledgement after all in-sync replicas have
		 * received the data. This option provides the best durability, we
		 * guarantee that no messages will be lost as long as at least one in
		 * sync replica remains.
		 */

		// props.put("request.required.acks", "-1");

		producer = new Producer<Integer, String>(new ProducerConfig(props));
		this.topic = topic;
	}

	@Override
	public void run() {
		int messageNo = 1;
		while (true) {
			String messageStr = new String("Message_" + messageNo);
			System.out.println("Send:" + messageStr);
			producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
			messageNo++;
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}