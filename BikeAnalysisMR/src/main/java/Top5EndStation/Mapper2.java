package Top5EndStation;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Mapper2 extends Mapper<LongWritable,Text, NullWritable, CompositeKeyWritable> {
    final static Logger logger = Logger.getLogger(Mapper2.class);
    TreeMap<Integer, String> top5 = new TreeMap<Integer, String>();
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        try {
            String row[] = value.toString().split("\t");
            logger.info("key"+row[1]+"value"+row[0]);
            top5.put(Integer.parseInt(row[1]), row[0]);
            if (top5.size() > 5)
                top5.remove(top5.firstKey());
        } catch (Exception ex) {
            System.out.print("exception mapper" + ex);
        }
    }
       protected void cleanup(Context context) throws IOException, InterruptedException{
            for(Map.Entry<Integer, String> entry : top5.entrySet()){
                context.write(NullWritable.get(), new CompositeKeyWritable(entry.getValue(),entry.getKey()));
            }

        }


    }

