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
    private static String charset = "GB2312"; //GB2312 �����ַ�����GBK-���ַ���

    /*
     * gzip��ʽѹ�����ļ�
     */
    public static void gzipCompress() {
	try {
	    //��Ϊ�ļ������������ʹ��GBK����GB2312���룬��Ȼ����ʱ��ҲҪʹ�øı�������������룬��װbufferReader���Ч��
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new FileInputStream(filename), charset));
	    BufferedOutputStream out = new BufferedOutputStream(
		    new GZIPOutputStream(new FileOutputStream(gzipname)));
	    System.out.println("��ʼ��ȡѹ���ļ�......");
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
	    System.out.println("��ȡ��Ϲر�����......");

	} catch (IOException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
}
