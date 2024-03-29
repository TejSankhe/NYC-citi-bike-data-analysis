package Top5Journey;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Mapper1 extends Mapper<LongWritable,Text, Text, IntWritable> {
    final static Logger logger = Logger.getLogger(Mapper1.class);
    IntWritable one =  new IntWritable(1);
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        try{
           String row[] = value.toString().split(",");
           if(!row[4].equals("end station name") && !row[4].equals("start station name") )
           context.write(new Text(row[4]+"->"+row[8]), one);
        } catch (Exception ex) {
            System.out.print("exception mapper"+ ex);
        }
    }
}
