package kafka;

public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {

	KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
	consumerThread.start();

	KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
	producerThread.start();

    }
}
