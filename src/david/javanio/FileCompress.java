package david.javanio;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileCompress {
    private static String filename = "goal.txt";
    private static String gzipname = "gzip.gz";
    private static String charset = "GB2312"; //GB2312 简体字符集，GBK-简繁字符集

    /*
     * gzip方式压缩单文件
     */
    public static void gzipCompress() {
	try {
	    //因为文件有中文你可以使用GBK或者GB2312编码，当然解码时候也要使用改变吗否则会产生乱码，包装bufferReader提高效率
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new FileInputStream(filename), charset));
	    BufferedOutputStream out = new BufferedOutputStream(
		    new GZIPOutputStream(new FileOutputStream(gzipname)));
	    System.out.println("开始读取压缩文件......");
	    int i;
	    while ((i = in.read()) != -1) {
		out.write(String.valueOf((char) i).getBytes(charset));
	    }

	    in.close();
	    out.close();
	    

	    BufferedReader resultIn = new BufferedReader(
		    new InputStreamReader(new GZIPInputStream(
			    new FileInputStream(gzipname)), charset));

	    String s;
	    while ((s = resultIn.readLine()) != null) {
		System.out.println(s);
	    }

	    resultIn.close();
	    System.out.println("读取完毕关闭连接......");

	} catch (IOException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
}
