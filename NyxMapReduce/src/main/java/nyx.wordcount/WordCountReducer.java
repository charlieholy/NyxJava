package nyx.wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, LongWritable,Text,LongWritable> {

    private LongWritable count = new LongWritable();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        super.setup(context);
        System.out.println("WordCountReducer setup....");
    }

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        super.reduce(key, values, context);
        System.out.println("WordCountReducer reduce...");
        long sum = 0;
        for (LongWritable value:values){
            sum += value.get();
        }
        count.set(sum);
        context.write(key,count);
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        super.cleanup(context);
        System.out.println("WordCountReducer cleanup...");

    }
}
