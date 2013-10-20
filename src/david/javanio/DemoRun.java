package david.javanio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import david.javanio.MappedIO.Tester;

public class DemoRun {
    private static FileChannelClass fcc = new FileChannelClass();
    private static ViewBuffers vb = new ViewBuffers();

    /*
     * 测试序列化简单对象
     */
    public static void serializeObjectDemo() {
	String persistence_path = "simpleObj.data";

	try {
	    ObjectOutputStream out = new ObjectOutputStream(
		    new FileOutputStream(persistence_path));

	    out.writeObject(new SimpleObject(1, "daviddai"));
	    out.close();

	    ObjectInputStream in = new ObjectInputStream(new FileInputStream(
		    persistence_path));

	    SimpleObject obj = (SimpleObject) in.readObject();
	    in.close();
	    System.out.println(obj.toString());

	    // System.out.println("---------------序列化数组----------------");
	    // String persistence_array_path = "simpleArrayObj.data";
	    // ObjectOutputStream outArr = new ObjectOutputStream(
	    // new FileOutputStream(persistence_array_path));
	    // outArr.writeObject(new SimpleObject[] {
	    // new SimpleObject(2, "mongodb"),
	    // new SimpleObject(3, "redis") });
	    // outArr.close();
	    //
	    // ObjectInputStream inArr = new ObjectInputStream(new
	    // FileInputStream(
	    // persistence_path));
	    //
	    // SimpleObject[] objArr = (SimpleObject[]) inArr.readObject();
	    // inArr.close();
	    // for (SimpleObject item : objArr) {
	    // System.out.println(item);
	    // }

	} catch (IOException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

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
	System.out.println(buffer.slice().capacity()); // slice为当前limit/capacity
						       // - position
    }
}
