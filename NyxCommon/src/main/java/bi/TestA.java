package bi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class TestA {
    public static void main(String[] args) throws IOException{
        test();
    }

    private static void test() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://127.0.0.1:8082");
        FileSystem fs = FileSystem.get(conf);
        boolean create = fs.createNewFile(new Path("/abc"));
        System.out.println(create);
        fs.close();
    }
}
