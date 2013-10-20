package david.javanio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.Timer;

import david.javanio.MappedIO.Tester;

public class DemoRun {
    private static FileChannelClass fcc = new FileChannelClass();
    private static ViewBuffers vb = new ViewBuffers();
    
    public static void zipCompressDemo() {
	try {
		ZipCompress.zipCompress();
	} catch (IOException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public static void lockingMappedFileDemo() {
	try {
	    LockingMappedFile.fc = new RandomAccessFile("lock.dat", "rw")
		    .getChannel();
	    MappedByteBuffer out = LockingMappedFile.fc.map(MapMode.READ_WRITE,
		    0, LockingMappedFile.LENGTH);
	    for (int i = 0; i < LockingMappedFile.LENGTH; i++) {
		out.put((byte) 'x');
	    }
	    System.out.println(String.format("%d~%d", 0,
		    LockingMappedFile.LENGTH / 3));
	    System.out.println(String.format("%d~%d",
		    LockingMappedFile.LENGTH / 2, LockingMappedFile.LENGTH / 2
			    + LockingMappedFile.LENGTH / 4));

	    new LockingMappedFile.LockAndModify(out, 0,
		    LockingMappedFile.LENGTH / 3);

	    new LockingMappedFile.LockAndModify(out,
		    LockingMappedFile.LENGTH / 2, LockingMappedFile.LENGTH / 2
			    + LockingMappedFile.LENGTH / 4);

	    // LockingMappedFile.fc.close();

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public static void testFramework() {
	for (Tester test : MappedIO.Tester.tests) {
	    test.runTest();
	}
    }

    public static void readFileByChannel() {
	new FileChannelClass().readFileByChannel();
    }

    public static void executeBufferPutAndGet() {
	fcc.bufferPutAndGet();
    }

    public static void executeIntBufferPutAndGet() {
	fcc.intBufferPutAndGet();
    }

    public static void viewBuffersDemo() {
	vb.viewBuffers();
    }

    public static void bigEndianOrlittleEndianDemo() {
	vb.bigEndianOrLittleEndian();
    }

    public static void switchNeighborByteElementDemo() {
	vb.switchNeighborByteElement();
    }

    public static void getChannel() {
	try {
	    fcc.getChannelDemo();
	    // fc.getChannelByCharBufferDemo();
	} catch (IOException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public static void byteBufferSlice() {
	ByteBuffer buffer = ByteBuffer.wrap("this is a buffer string"
		.getBytes());
	System.out.println(buffer.capacity());
	buffer.position(5);
	System.out.println(buffer.slice().capacity()); // sliceÎªµ±Ç°limit/capacity
						       // - position
    }
}
