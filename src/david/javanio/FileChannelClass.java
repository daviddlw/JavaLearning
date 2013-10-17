package david.javanio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import david.thinkinginJava.TextFile;

public class FileChannelClass {

    private static final int SIZE = 1024;
    private final String Encoding_STR = "file.encoding";

    @SuppressWarnings("resource")
    public void readFileByChannel() {
	try {
	    ByteBuffer buffers = ByteBuffer.wrap(TextFile.read("goal.txt")
		    .getBytes("UTF-16BE"));
//	    String encoding = System.getProperty(Encoding_STR);
//	    Charset.forName(encoding).decode(buffers);
//	    buffers.flip();
	    // queryPosition("encoding后...", buffers);
	    System.out.println(buffers.asCharBuffer());

	} catch (IOException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}

    }

    /*
     * 查询当前ByteBuffer的Postion位置
     */
    private void queryPosition(String desc, ByteBuffer buffer) {
	System.out.println(desc + buffer.position());
    }

    public void getChannelDemo() throws IOException {
	String text = "data.txt";
	FileChannel fc = new FileOutputStream(text).getChannel();
	fc.write(ByteBuffer.wrap("some text was written".getBytes()));
	fc.close();
	fc = new RandomAccessFile(text, "rw").getChannel();
	fc.position(fc.size());
	fc.write(ByteBuffer.wrap(" some more words".getBytes()));
	fc.close();
	fc = new FileInputStream(text).getChannel();
	ByteBuffer buffer = ByteBuffer.allocate(SIZE);
	fc.read(buffer);
	buffer.flip();
	while (buffer.hasRemaining()) {
	    System.out.print((char) buffer.get());
	}
    }

    public void getChannelByCharBufferDemo() throws IOException {
	String text = "data.txt";
	FileChannel fc = new FileOutputStream(text).getChannel();
	fc.write(ByteBuffer.wrap("some text was written".getBytes("UTF-16BE")));
	fc.close();
	fc = new RandomAccessFile(text, "rw").getChannel();
	fc.position(fc.size());
	fc.write(ByteBuffer.wrap(" some more words".getBytes("UTF-16BE")));
	fc.close();
	fc = new FileInputStream(text).getChannel();
	ByteBuffer buffer = ByteBuffer.allocate(SIZE);
	fc.read(buffer);
	buffer.flip();
	// buffer.rewind();
	// String encoding = System.getProperty("file.encoding");
	// System.out.println("decoded using " + encoding + " : "
	// + Charset.forName(encoding).decode(buffer));
	while (buffer.hasRemaining()) {
	    System.out.println(buffer.asCharBuffer());
	}
    }
}
