package david.javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;

public class BasicFileOutput {
    
    /*
     * �Ƚ���û�л��������µ�д��Ч������
     */
    public static void bufferCompareDemo() {
	String noBuffer = "nobuffered.txt";
	String buffer = "buffered.txt";
	String sourepath = ".//TextFile.java";
	StopWatch stopWatch = new StopWatch();
	try {
	    PrintWriter outNoBuffer = new PrintWriter(noBuffer);
	    PrintWriter outBuffer = new PrintWriter(buffer);

	    System.out.println("no buffer д���ʱ��ʼ...");
	    stopWatch.start();
	    for (String item : noBufferReader(sourepath)) {
		outNoBuffer.println(item);
	    }
	    outNoBuffer.close();
	    stopWatch.stop();
	    System.out.println("no buffer д���ʱ����...");
	    System.out.println(String.format("nanotime=> %d, time=>%d",
		    stopWatch.getNanoTime(), stopWatch.getTime()));
	    System.out.println("------------------�ָ���----------------");
	    System.out.println("����stopwatch");
	    stopWatch.reset();
	    stopWatch.start();
	    System.out.println("buffer д���ʱ��ʼ...");
	    for (String item : bufferReader(sourepath)) {
		outBuffer.println(item);
	    }
	    outBuffer.close();
	    stopWatch.stop();
	    System.out.println("buffer д���ʱ����...");
	    System.out.println(String.format("nanotime=> %d, time=>%d",
		    stopWatch.getNanoTime(), stopWatch.getTime()));

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /*
     * û��ʹ��bufferReader������װ��
     */
    private static List<String> noBufferReader(String path) throws IOException {
	FileReader in = new FileReader(new File(path));
	List<String> ls = new ArrayList<String>();
	int s;
	while ((s = in.read()) != -1) {
	    ls.add(String.valueOf((char) s));
	}
	in.close();
	return ls;
    }

    private static List<String> bufferReader(String path) throws IOException {
	BufferedReader in = new BufferedReader(new FileReader(path));
	List<String> ls = new ArrayList<String>();
	String line;
	while ((line = in.readLine()) != null) {
	    ls.add(line);
	}
	in.close();
	return ls;
    }

    public static void printWriterDemo(String path) throws IOException {
	String dest = "dest.txt";
	List<String> linkedList = BufferedInputFile.readToList(new File(path));
	PrintWriter out = new PrintWriter(dest);
	String s;
	int lineCount = 1;
	for (String item : linkedList) {
	    out.println(String.format("%d : %s", lineCount++, item));
	}
	out.close();
	System.out.println(BufferedInputFile.read(dest));
    }

    public static void basicFileOutput(String path) throws IOException {
	String file = "BasicFileOutput.txt";
	BufferedReader in = new BufferedReader(new StringReader(
		BufferedInputFile.read(path)));
	PrintWriter out = new PrintWriter(file);
	int lineCount = 1;
	String s;
	while ((s = in.readLine()) != null) {
	    out.println(String.format("%d ��%s", lineCount++, s));
	}
	in.close();
	out.close();
	System.out.println(BufferedInputFile.read(file));
    }
}
