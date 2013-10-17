package david.javanio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
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
			// String encoding = System.getProperty(Encoding_STR);
			// Charset.forName(encoding).decode(buffers);
			// buffers.flip();
			// queryPosition("encoding后...", buffers);
			System.out.println(buffers.asCharBuffer());

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * IntBuffer数组
	 */
	public void intBufferPutAndGet() {
		ByteBuffer buffer = ByteBuffer.allocate(SIZE);
		IntBuffer intBuffer = buffer.asIntBuffer();
		intBuffer.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
		System.out.println(intBuffer.get(3));
		intBuffer.put(3, 888);
		intBuffer.flip();
		while (intBuffer.hasRemaining()) {
			System.out.print(intBuffer.get() + " ");
		}
	}

	/*
	 * bytebuffer，put,get各种基本数据流
	 */
	public void bufferPutAndGet() {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(SIZE);
			int index = 0;
			while (index++ < buffer.limit()) {
				if (buffer.get() != 0) {
					System.out.println("nonzero");
				}
			}
			System.out.println("i = " + index);
			buffer.rewind();
			buffer.asCharBuffer().put("hello byte buffer");
			char c;
			while ((c = buffer.getChar()) != 0) {
				System.out.print(c);
			}
			System.out.println();
			buffer.rewind();
			buffer.asDoubleBuffer().put(88.88);
			double d;
			System.out.println(buffer.getDouble());
			buffer.rewind();
			buffer.asFloatBuffer().put(99.9f);
			float f;
			System.out.println(buffer.getFloat());
			buffer.rewind();
			buffer.asIntBuffer().put(123);
			int i;
			System.out.println(buffer.getInt());
			buffer.rewind();
			buffer.asLongBuffer().put(123456789);
			long l;
			System.out.println(buffer.getLong());
			buffer.rewind();
			buffer.asShortBuffer().put((short) 12312);
			short s;
			System.out.println(buffer.getShort());
			// System.out.println("--------------");
			// buffer.rewind();
			// buffer.asIntBuffer().put(123123);
			// while (buffer.hasRemaining()) {
			// System.out.println(buffer.hasRemaining());
			// System.out.println(buffer.remaining());
			// System.out.println(buffer.getInt());
			// }

		} catch (Exception e) {
			// TODO: handle exception
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
