package nyx.wordcount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.FileInputStream;

public class WordCountRunner implements Tool {
    public Configuration getConf() {
        return conf;
    }

    public void setConf(Configuration conf) {

        this.conf = conf;
        this.conf.set("fs.defaultFS","hdfs://localhost:9000");
    }

    private Configuration conf = null;

    public int run(String[] strings) throws Exception {
        Configuration configuration;
        Job job = Job.getInstance(conf,"wordcount");
//        //input
        FileInputFormat.addInputPath(job,new Path("input/"));
//        //map
        job.setMapperClass(WordCountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
//  3.shuffle
        //4.reducer
        job.setReducerClass(WordCountReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //output
        FileOutputFormat.setOutputPath(job,new Path("wordcount2"));

        return job.waitForCompletion(true) ? 0: 1;
    }

    public static void main(String[] args) throws Exception {
        ToolRunner.run(new WordCountRunner(),args);
        //ToolRunner.
    }
}
