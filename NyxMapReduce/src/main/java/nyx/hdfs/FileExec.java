package nyx.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class FileExec {
    public static void main(String[] args) throws IOException {
        //testCreate();
        testAppend();
    }

    private static void testCreate() throws IOException {
        Configuration conf =  new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(conf);
        boolean create = fs.createNewFile(new Path("jjj.txt"));
        System.out.println(create);
        fs.close();
    }

    private static void testAppend() throws IOException {
        Configuration conf =  new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("jjj.txt");
        FSDataOutputStream dos = fs.append(path);
        dos.write("abc".getBytes());
        dos.close();
        fs.close();
    }


}
