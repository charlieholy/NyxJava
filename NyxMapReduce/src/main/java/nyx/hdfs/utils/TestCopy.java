package nyx.hdfs.utils;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class TestCopy {
    public static void main(String[] args) throws IOException {
        testCopyFromLocal();;
        //testCopyToLocal();

    }
    static void testCopyFromLocal() throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        fs.copyFromLocalFile(new Path("/Users/chenpeiwen/3.txt"),new Path("input/3.txt"));
        fs.close();
    }

    static void testCopyToLocal() throws IOException {
        FileSystem fs = HdfsUtil.getFileSystem();
        fs.copyToLocalFile(new Path("2.txt"),new Path("/Users/chenpeiwen/2.txt"));
        fs.close();
    }


}
