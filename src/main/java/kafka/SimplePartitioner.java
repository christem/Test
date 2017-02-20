package kafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * 用于指定kafka分区存储策略
 * 
 * @author Suny
 *
 */
public class SimplePartitioner implements Partitioner {

	public SimplePartitioner(VerifiableProperties props) {
	}

	@Override
	public int partition(Object key, int numPartitions) {
		int partition = 0;
		try {
			String k = key + "";
			partition = Math.abs(k.hashCode()) % numPartitions;
		} catch (Exception e) {
		}
		return partition;
	}
}
