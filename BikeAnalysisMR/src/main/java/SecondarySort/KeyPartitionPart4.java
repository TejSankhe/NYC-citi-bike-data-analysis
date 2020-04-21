package SecondarySort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class KeyPartitionPart4 extends Partitioner<CompositeKeyWritablePart4, NullWritable>{

	@Override
	public int getPartition(CompositeKeyWritablePart4 key, NullWritable value, int numPartitions) {
		
		return key.getstationName().hashCode()%numPartitions;
		
	}

}
