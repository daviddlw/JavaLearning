package david.javanio;

import java.io.IOException;

public class DemoRun {
    private static FileChannelClass fc = new FileChannelClass();

    public static void getChannel() {
	try {
	    fc.getChannelDemo();
//	    fc.getChannelByCharBufferDemo();
	} catch (IOException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public static void readFileByChannel() {
	new FileChannelClass().readFileByChannel();
    }
}
