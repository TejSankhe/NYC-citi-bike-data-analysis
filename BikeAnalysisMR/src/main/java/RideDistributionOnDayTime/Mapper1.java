package RideDistributionOnDayTime;

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
           if(!row[1].equals("\"starttime\"")) {
                String date_time[] = row[1].split(" ");
               String time[] = date_time[1].trim().split(":");
                context.write(new Text(time[0]), one);
           }

        } catch (Exception ex) {
            System.out.print("exception mapper"+ ex);
        }


    }
}
