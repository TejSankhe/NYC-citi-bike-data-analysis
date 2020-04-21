package Top5StartStation;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Driver {
    public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException
    {
        Job job = Job.getInstance();

        job.setJarByClass(Driver.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        Path outDir = new Path(args[1]);
        FileOutputFormat.setOutputPath(job, outDir);

        job.setMapperClass(Mapper1.class);
        job.setReducerClass(Reducer1.class);

        //job.setMapOutputKeyClass(DateIPObject.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text .class);
        job.setOutputValueClass(IntWritable.class);


        job.setCombinerClass(Reducer1.class);
        if (!job.waitForCompletion(true)) {
            System.exit(1);
        }

        Job job2 = Job.getInstance();

        job2.setJarByClass(Driver.class);

        FileInputFormat.addInputPath(job2, new Path(args[1]));
         outDir = new Path(args[2]);
        FileOutputFormat.setOutputPath(job2, outDir);

        job2.setMapperClass(Mapper2.class);
        job2.setReducerClass(Reducer2.class);

        //job.setMapOutputKeyClass(DateIPObject.class);
        job2.setMapOutputKeyClass(NullWritable.class);
        job2.setMapOutputValueClass(CompositeKeyWritable.class);
        job2.setOutputKeyClass(Text .class);
        job2.setOutputValueClass(IntWritable.class);
        if (!job2.waitForCompletion(true)) {
            System.exit(1);
        }


    }
}
