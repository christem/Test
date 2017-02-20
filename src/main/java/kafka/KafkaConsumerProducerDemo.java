package kafka;

public class KafkaConsumerProducerDemo {
	public static void main(String[] args) throws InterruptedException {

		// KafkaProducer producerThread = new
		// KafkaProducer(KafkaProperties.topic);
		// producerThread.start();
		//
		// Thread.sleep(3000);

		KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic2);
		consumerThread.start();

	}
}
