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
    private static String source_path = "G:\\开发\\Java\\测试压缩文件夹";
    private static String zipfile_path = "test.zip";
    private static String charset = "GBK";
    private static String empty = "空";
    private static List<File> ls = new ArrayList<File>();

    public static void zipCompress() throws IOException {

	FileOutputStream fos = new FileOutputStream(zipfile_path);// 包装file流
	CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32()); // 为file添加校验值
	ZipOutputStream zos = new ZipOutputStream(cos); // 生成zip流
	BufferedOutputStream bos = new BufferedOutputStream(zos); //

	List<File> files = getFileList(new File(source_path));
	int index = 0;
	System.out.println("开始压缩" + files.size() + "个文件......");
	for (File file : files) {
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new FileInputStream(file), charset));
	    zos.putNextEntry(new ZipEntry(file.getName()));
	    // 第一个设置comment
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
	System.out.println("压缩完毕......");
	System.out.println("Checksum => " + cos.getChecksum().getValue());

	FileInputStream fis = new FileInputStream(zipfile_path);
	CheckedInputStream cis = new CheckedInputStream(fis, new Adler32());
	ZipInputStream zis = new ZipInputStream(cis);
	BufferedReader bis = new BufferedReader(new InputStreamReader(zis,
		charset));

	// 通过ZipEntry读取压缩文件
	readByZipEntry(zis, bis);
	// 通过ZipFile读取文件
//	readByZipFile(zis, bis);

	System.out.println("Checksum => " + cos.getChecksum().getValue());
    }

    private static void readByZipFile(ZipInputStream zis, BufferedReader bis)
	    throws IOException {

	ZipFile zf = new ZipFile(zipfile_path);
	Enumeration<? extends ZipEntry> e = zf.entries();
	while (e.hasMoreElements()) {
	    ZipEntry ze = (ZipEntry) e.nextElement();
	    System.out.println("读取压缩文件条目: "
		    + new ZipEntryElement(ze).toString());
	    String s;
	    System.out.println("--------------文件分割线------------");
	    while ((s = bis.readLine()) != null) {
		System.out.println(s);
	    }
	}
    }

    private static void readByZipEntry(ZipInputStream zis, BufferedReader bis)
	    throws IOException {

	ZipEntry ze = null;
	while ((ze = zis.getNextEntry()) != null) {
	    System.out.println("读取压缩文件条目: "
		    + new ZipEntryElement(ze).toString());
	    String s;
	    System.out.println("--------------文件分割线------------");
	    while ((s = bis.readLine()) != null) {
		System.out.println(s);
	    }
	}
    }

    /*
     * 递归查找出所有文件，并且返回
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
     * 自定义一个ZipEntry为了toString显示name与comment
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
