package david.javanio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
    private static String source_path = "G:\\����\\Java\\����ѹ���ļ���";
    private static String zipfile_path = "test.zip";
    private static String charset = "GBK";
    private static String empty = "��";
    private static List<File> ls = new ArrayList<File>();

    public static void zipCompress() throws IOException {

	FileOutputStream fos = new FileOutputStream(zipfile_path);// ��װfile��
	CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32()); // Ϊfile���У��ֵ
	ZipOutputStream zos = new ZipOutputStream(cos); // ����zip��
	BufferedOutputStream bos = new BufferedOutputStream(zos); //

	List<File> files = getFileList(new File(source_path));
	int index = 0;
	System.out.println("��ʼѹ��" + files.size() + "���ļ�......");
	for (File file : files) {
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new FileInputStream(file), charset));
	    zos.putNextEntry(new ZipEntry(file.getName()));
	    // ��һ������comment
	    if (index == 0)
		zos.setComment("number one");
	    index++;

	    int c;
	    while ((c = in.read()) != -1) {
		bos.write(String.valueOf((char) c).getBytes(charset));
	    }
	    in.close();
	    bos.flush();
	}
	bos.close();
	System.out.println("ѹ�����......");
	System.out.println("Checksum => " + cos.getChecksum().getValue());

	FileInputStream fis = new FileInputStream(zipfile_path);
	CheckedInputStream cis = new CheckedInputStream(fis, new Adler32());
	ZipInputStream zis = new ZipInputStream(cis);
	BufferedReader bis = new BufferedReader(new InputStreamReader(zis,
		charset));

	// ͨ��ZipEntry��ȡѹ���ļ�
	readByZipEntry(zis, bis);
	// ͨ��ZipFile��ȡ�ļ�
//	readByZipFile(zis, bis);

	System.out.println("Checksum => " + cos.getChecksum().getValue());
    }

    private static void readByZipFile(ZipInputStream zis, BufferedReader bis)
	    throws IOException {

	ZipFile zf = new ZipFile(zipfile_path);
	Enumeration<? extends ZipEntry> e = zf.entries();
	while (e.hasMoreElements()) {
	    ZipEntry ze = (ZipEntry) e.nextElement();
	    System.out.println("��ȡѹ���ļ���Ŀ: "
		    + new ZipEntryElement(ze).toString());
	    String s;
	    System.out.println("--------------�ļ��ָ���------------");
	    while ((s = bis.readLine()) != null) {
		System.out.println(s);
	    }
	}
    }

    private static void readByZipEntry(ZipInputStream zis, BufferedReader bis)
	    throws IOException {

	ZipEntry ze = null;
	while ((ze = zis.getNextEntry()) != null) {
	    System.out.println("��ȡѹ���ļ���Ŀ: "
		    + new ZipEntryElement(ze).toString());
	    String s;
	    System.out.println("--------------�ļ��ָ���------------");
	    while ((s = bis.readLine()) != null) {
		System.out.println(s);
	    }
	}
    }

    /*
     * �ݹ���ҳ������ļ������ҷ���
     */

    private static List<File> getFileList(File file) {

	for (File item : file.listFiles()) {
	    if (item.isDirectory()) {
		getFileList(item);
	    } else {
		ls.add(item);
	    }
	}

	return ls;
    }

    /*
     * �Զ���һ��ZipEntryΪ��toString��ʾname��comment
     */
    private static class ZipEntryElement {
	private String name;
	private String comment;

	public ZipEntryElement(ZipEntry ze) {
	    // TODO Auto-generated constructor stub
	    this.name = ze.getName() == null ? empty : ze.getName();
	    this.comment = ze.getComment() == null ? empty : ze.getComment();
	}

	@Override
	public String toString() {
	    // TODO Auto-generated method stub
	    return String.format("name: %s, comment: %s", name, comment);
	}
    }
}
