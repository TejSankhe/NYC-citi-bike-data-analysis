package SecondarySort;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class DriverPart4 {
    public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException
    {
        Job job = Job.getInstance();

        job.setJarByClass(DriverPart4.class);

        job.setGroupingComparatorClass(GroupComparatorPart4.class);
        job.setSortComparatorClass(DateCompartorPart4.class);
        job.setPartitionerClass(KeyPartitionPart4.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        Path outDir = new Path(args[1]);
        FileOutputFormat.setOutputPath(job, outDir);

        job.setMapperClass(KeyMapperPart4.class);
        job.setReducerClass(KeyReducerPart4.class);

        //job.setMapOutputKeyClass(DateIPObject.class);
        job.setMapOutputKeyClass(CompositeKeyWritablePart4.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setNumReduceTasks(1);



        job.setOutputKeyClass(CompositeKeyWritablePart4 .class);
        job.setOutputValueClass(NullWritable.class);


        job.waitForCompletion(true);
    }
}
