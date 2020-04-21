package SecondarySort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyMapperPart4 extends Mapper<LongWritable,Text, CompositeKeyWritablePart4,NullWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        try{
            String logData[] = value.toString().split(",");
            String stationname = logData[4];


            if (logData.length!=0 && (!logData[0].equalsIgnoreCase("tripduration") && !logData[0].equalsIgnoreCase("\"tripduration\""))) {
                int tripduration = Integer.parseInt(logData[0]);
                CompositeKeyWritablePart4 dateIp = new CompositeKeyWritablePart4(stationname,tripduration);

                context.write(dateIp,NullWritable.get());

            }


        } catch (Exception ex) {
            System.out.print("exception mapper"+ ex);
        }


    }
}
