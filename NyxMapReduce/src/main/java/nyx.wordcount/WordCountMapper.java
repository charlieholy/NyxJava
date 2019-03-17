package nyx.wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class WordCountMapper extends Mapper<Object, Text,Text,LongWritable> {

    private Text word = new Text();
    private LongWritable one = new LongWritable(1);

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        super.setup(context);
        System.out.println("called setup wordCountMapper setup...");
    }

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        super.map(key, value, context);
        System.out.println("call map...");
        String line = value.toString();
        StringTokenizer tokenizer =  new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()){
            word.set(tokenizer.nextToken());
            context.write(word,one);
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        super.cleanup(context);
        System.out.println("call clean up....");

    }
}
