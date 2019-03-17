package nyx.wordcount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;

import java.io.FileInputStream;

public class WordCountRunner implements Tool {
    public Configuration getConf() {
        return conf;
    }

    public void setConf(Configuration conf) {
        this.conf = conf;
    }

    private Configuration conf = null;

    public int run(String[] strings) throws Exception {
        Configuration configuration;
        Job job = Job.getInstance(conf,"wordcount");
//        //input
//        FileInputFormat.addInputPath(job,new Path("/"));
//        //map
//        job.setMapperClass(WordCountMapper.class);

        return 0;
    }
}
