import io.netty.buffer.*;
import sun.nio.cs.US_ASCII;

import java.nio.ByteBuffer;

public class ByteBuf2 {
    public static void main(String[] args) {
        byte[] bbb = {1,2};
        ByteBuf b = Unpooled.buffer(40);
        b.writeBytes(bbb);
        b.writeByte(3);
        b.setByte(1,1);

        ByteBuffer byteBuffer = b.nioBuffer();
        System.out.println("h:" + byteBuffer.limit());
        //int bb = b.readerIndex();
        //System.out.println(bb);
        //b.markReaderIndex();
        //b.readerIndex(0);

        //b.setByte(0,1);
        //b.resetReaderIndex();
        int a = b.readableBytes();

        System.out.println(a);
        String ss = ByteBufUtil.hexDump(b);
        System.out.println(ss);
        System.out.println("nani");
        System.out.println(b);
    }
}
