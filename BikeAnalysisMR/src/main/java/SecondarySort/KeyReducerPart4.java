package SecondarySort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class KeyReducerPart4 extends Reducer<CompositeKeyWritablePart4, NullWritable,CompositeKeyWritablePart4,NullWritable>{
    @Override
    protected void reduce(CompositeKeyWritablePart4 key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
       try{
           for (NullWritable n: values) {
               context.write(key, NullWritable.get());

           }



       } catch(Exception e) {
           System.out.print("reducer errors"+e);
       }

    }
}
