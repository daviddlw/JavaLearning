package david.javanio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class MappedIO {
	private static int numOfInts = 400000;
	private static int numOfBufferedInts = 200000;

	public abstract static class Tester {
		private String name;

		public Tester(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}

		public void runTest() {
			try {
				System.out.print(name + ": ");
				long start = System.nanoTime();
				test();
				long duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration / 1.09e9);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		public abstract void test() throws IOException;
		private static String filename = "dest.txt";

		@SuppressWarnings("resource")
		public static Tester[] tests = {new Tester("Stream Writer") {

			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				DataOutputStream out = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream(
								"dest.txt")));
				for (int i = 0; i < numOfInts; i++) {
					out.writeInt(i);
				}
				out.close();
			}
		}, new Tester("Mapped Writer") {

			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				FileChannel fc = new RandomAccessFile(filename, "rw")
						.getChannel();
				IntBuffer ib = fc.map(MapMode.READ_WRITE, 0, fc.size())
						.asIntBuffer();
				for (int i = 0; i < numOfInts; i++) {
					ib.put(i);
				}
				fc.close();
			}
		}, new Tester("Stream Reader") {

			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				DataInputStream in = new DataInputStream(
						new BufferedInputStream(new FileInputStream(filename)));
				for (int i = 0; i < numOfInts; i++) {
					in.readInt();
				}
				in.close();
			}
		}, new Tester("Mapped Reader") {

			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				FileChannel fc = new RandomAccessFile(filename, "r")
						.getChannel();
				IntBuffer in = fc.map(MapMode.READ_ONLY, 0, fc.size())
						.asIntBuffer();
				while (in.hasRemaining()) {
					in.get();
				}
				fc.close();
			}
		}, new Tester("Stream Read/Write") {

			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				RandomAccessFile raf = new RandomAccessFile(filename, "rw");
				raf.write(1);
				for (int i = 0; i < numOfBufferedInts; i++) {
					raf.seek(raf.length() - 4);
					raf.writeInt(raf.readInt());
				}
				raf.close();
			}
		}, new Tester("Mapped Read/Write") {

			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				FileChannel fc = new RandomAccessFile(filename, "rw")
						.getChannel();
				IntBuffer ib = fc.map(MapMode.READ_WRITE, 0, fc.size())
						.asIntBuffer();
				ib.put(0);
				for (int i = 1; i < numOfBufferedInts; i++) {
					ib.put(ib.get(i - 1));
				}
				fc.close();
			}
		}
		};
	}
}
