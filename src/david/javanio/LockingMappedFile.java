package david.javanio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFile {
	static int LENGTH = 0x8FFFF;
	static FileChannel fc;

	public static class LockAndModify extends Thread {
		private ByteBuffer buffer;
		private int start, end;
		public LockAndModify(ByteBuffer buffer, int start, int end) {
			// TODO Auto-generated constructor stub
			this.start = start;
			this.end = end;
			buffer.limit(end);
			buffer.position(start);
			this.buffer = buffer.slice();
			start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				FileLock flock = fc.lock(start, end, false);
				System.out.println("Locked: " + start + " to " + end);
				while (buffer.position() < buffer.limit() - 1) {
					buffer.put((byte) (buffer.get() + 1));
				}
				flock.release();
				System.out.println("Release: " + start + " to " + end);
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
	}
}
