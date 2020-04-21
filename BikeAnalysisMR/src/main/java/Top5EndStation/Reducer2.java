package Top5EndStation;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class Reducer2 extends Reducer<NullWritable, CompositeKeyWritable,Text,IntWritable>{
    TreeMap<Integer, String> top5 = new TreeMap<Integer, String>();
    public void reduce(NullWritable key, Iterable<CompositeKeyWritable> values, Context context) throws IOException, InterruptedException {
        for(CompositeKeyWritable value : values) {
            top5.put(value.getCount(),value.getStationName());
            if (top5.size() > 5)
                top5.remove(top5.firstKey());
        }
        for(Map.Entry<Integer, String> entry : top5.descendingMap().entrySet()){
            context.write(new Text(entry.getValue()),new IntWritable(entry.getKey()));
        }
    }
}

