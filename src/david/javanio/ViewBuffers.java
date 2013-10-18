package david.javanio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

public class ViewBuffers {

	public void switchNeighborByteElement() {
		long start = System.currentTimeMillis();
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		cb.rewind();
		System.out.println(cb);
		changeElements(cb);
		cb.rewind();
		System.out.println(cb);
		changeElements(cb);
		cb.rewind();
		System.out.println(cb);
		System.out.println("耗时... => " + (System.currentTimeMillis() - start));
	}

	private void changeElements(CharBuffer buffer) {
		while (buffer.hasRemaining()) {
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset(); // 将标志位返回原始位置例如第一返回0
			buffer.put(c2).put(c1);
		}
	}

	/*
	 * ByteBuffer的高位还是低位有结果（高位重要的数据放最低的存储器，低位重要数据放在最高的存储器）
	 */
	public void bigEndianOrLittleEndian() {

		ByteBuffer buffer = ByteBuffer.wrap(new byte[12]);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		buffer.rewind();
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		buffer.rewind();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
	}

	/*
	 * 查询不同基本数据类型在bytebuffer中的占位情况
	 */
	public void viewBuffers() {
		ByteBuffer bf = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
		bf.rewind();
		System.out.print("Byte buffer: ");
		while (bf.hasRemaining()) {
			System.out.print(String.format("%d => %s, ", bf.position(),
					bf.get()));
		}

		System.out.println();
		CharBuffer cf = ((ByteBuffer) bf.rewind()).asCharBuffer();
		System.out.print("Char buffer: ");
		while (cf.hasRemaining()) {
			System.out.print(String.format("%d => %s, ", cf.position(),
					cf.get()));
		}

		System.out.println();
		ShortBuffer sf = ((ByteBuffer) bf.rewind()).asShortBuffer();
		System.out.print("Short buffer: ");
		while (sf.hasRemaining()) {
			System.out.print(String.format("%d => %s, ", sf.position(),
					sf.get()));
		}

		System.out.println();
		IntBuffer intf = ((ByteBuffer) bf.rewind()).asIntBuffer();
		System.out.print("Int buffer: ");
		while (intf.hasRemaining()) {
			System.out.print(String.format("%d => %s, ", intf.position(),
					intf.get()));
		}

		System.out.println();
		FloatBuffer ff = ((ByteBuffer) bf.rewind()).asFloatBuffer();
		System.out.print("Float buffer: ");
		while (ff.hasRemaining()) {
			System.out.print(String.format("%d => %s, ", ff.position(),
					ff.get()));
		}

		System.out.println();
		DoubleBuffer df = ((ByteBuffer) bf.rewind()).asDoubleBuffer();
		System.out.print("Double buffer: ");
		while (df.hasRemaining()) {
			System.out.print(String.format("%d => %s, ", df.position(),
					df.get()));
		}

		System.out.println();
		LongBuffer lf = ((ByteBuffer) bf.rewind()).asLongBuffer();
		System.out.print("Long buffer: ");
		while (lf.hasRemaining()) {
			System.out.print(String.format("%d => %s, ", lf.position(),
					lf.get()));
		}
	}
}
