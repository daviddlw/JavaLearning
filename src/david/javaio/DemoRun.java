package david.javaio;

import java.awt.image.IndexColorModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

import david.deepInCollection.CountedMapData;
import david.deepInCollection.CustomCountedString;
import david.deepInCollection.MapGenerator;
import david.deepInCollection.SimpleHashMap;
import david.deepInCollection.SlowMap;
import david.deepInCollection.SortedDirList;
import david.util.StringUtil;
import david.util.TextFile;

public class DemoRun {

	private static int number = 1000;
	private final static String READ = "r";
	private final static String READ_AND_WRITE = "rw";
	
	/*
	 * thinking in java练习题
	 */
	public static void calcuateToMap() {
		calculateCharactersDemo();
		calculateBytesDemo();
	}
	
	/*
	 * 按照不同字节数统计
	 */
	private static void calculateBytesDemo() {
		String fileContent = TextFile.read(new File(".//goal.txt")
				.getAbsolutePath());
		Map<Byte, Integer> map = new TreeMap<Byte, Integer>();
		byte[] bytesArray = fileContent.getBytes();
		for (byte b : bytesArray) {
			String s = String.valueOf(b);
			if (!s.isEmpty()) {
				if (map.containsKey(b)) {
					map.put(new Byte(b), map.get(b) + 1);
				} else {
					map.put(new Byte(b), 1);
				}
			}
		}
		System.out.println(map);
	}

	/*
	 * 计算文件内各个字符出现次数
	 */
	private static void calculateCharactersDemo() {
		String fileContent = TextFile.read(new File(".//goal.txt")
				.getAbsolutePath());
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		char[] charArray = fileContent.toCharArray();
		for (char c : charArray) {
			String s = String.valueOf(c);
			if (!s.isEmpty() && Pattern.matches("[a-zA-Z]", s)) {
				if (map.containsKey(c)) {
					map.put(new Character(c), map.get(c) + 1);
				} else {
					map.put(new Character(c), 1);
				}
			}
		}
		System.out.println(map);
	}

	public static void textFileDemo() {
		String path = ".//dest.txt";
		String fileContent = TextFile.read(path);
		System.out.println(fileContent);
		TextFile.write("goal.txt", fileContent);
		TextFile tf = new TextFile("goal.txt");
		tf.write("goal2.txt");
		TreeSet<String> words = new TreeSet<String>(new TextFile("goal2.txt",
				"\\W+"));
		System.out.println(words.headSet("d")); // 返回大于b的所有treeset
	}

	public static void randomFileAccessDemo() {
		String path = "BasicFileOutput.txt";
		String destPath = "dest.txt";
		try {
			RandomAccessFile in = new RandomAccessFile(new File(path), READ);
			RandomAccessFile out = new RandomAccessFile(new File(destPath),
					READ_AND_WRITE);

			String addString = "7 ：added by daviddai";
			byte[] addBytes = addString.getBytes();
			byte[] inBytes = new byte[(int) in.length()]; // 根据length()属性返回所读取的文件的长度
			in.read(inBytes, 0, (int) in.length());
			out.write(inBytes); // 从inBytes数组首次读出数据写入out流
			out.write(addBytes, 0, addBytes.length); // 从addBytes数组读取数据追加写入out流
			in.close();
			out.close();

			// System.out.println(sb.toString());
			System.out.println("输入成功！");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void inAndOutStreamDemo() {
		String dest = "dest.txt";
		try {
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(dest)));
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(dest)));

			out.writeInt(8888);
			out.writeBoolean(true);
			out.writeChar(65);
			out.writeDouble(88.88);
			out.writeLong(888888888);
			out.writeInt(99999);
			out.writeUTF("你好爪哇!");
			out.writeUTF("爪哇编程思想");
			out.close();

			System.out.println(in.readInt());
			System.out.println(in.readBoolean());
			System.out.println(in.readChar());
			System.out.println(in.readDouble());
			System.out.println(in.readLong());
			System.out.println(in.readInt());
			System.out.println(in.readUTF());
			System.out.println(in.readUTF());
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public static void bufferedInputFileDemo() {
		try {
			String path = ".//testHelloWorld.txt";
			System.out.println(BufferedInputFile.read(path));
			StringUtil.printSplitLines();
			System.out.println(BufferedInputFile.readByReverse(path));
			StringUtil.printSplitLines();
			System.out.println(BufferedInputFile.upperArrayList(path));
			StringUtil.printSplitLines();
			System.out.println(BufferedInputFile.searchedList(path, "do you"));
			StringUtil.printSplitLines();
			System.out.println(MemoryInput.readBySingleChar(path));
			StringUtil.printSplitLines();
			FormattedMemoryInput.formattedMemoryInput(path);
			StringUtil.printSplitLines();
			BasicFileOutput.basicFileOutput(path);
			StringUtil.printSplitLines();
			BasicFileOutput.printWriterDemo(path);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void searchFilesDemo() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 0, 1, 0, 0, 0);
		String filepath = "D:\\";
		File file = new File(filepath);
		List<SearchedFile> searchedResult = new ArrayList<SearchedFile>();
		for (File item : file.listFiles()) {
			Calendar lastmodifiedDate = Calendar.getInstance();
			lastmodifiedDate.clear();
			lastmodifiedDate.setTimeInMillis(item.lastModified());
			if (lastmodifiedDate.compareTo(calendar) > 0) {
				if (!item.isHidden()) {
					SearchedFile sf = new SearchedFile(item.getName(),
							lastmodifiedDate);
					searchedResult.add(sf);
				}
			}
		}

		Collections.sort(searchedResult);
		for (SearchedFile sitem : searchedResult) {
			System.out.println(sitem.toString());
		}
	}

	public static void apacheCommons() {
		StrBuilder sb = new StrBuilder();
		sb.appendln("hello");
		sb.append("world");
		System.out.println(sb.toString());
		System.out.println("�ָ���");
		StringBuilder sb2 = new StringBuilder();
		sb2.append("hello");
		sb2.append("world");
		System.out.println(sb2.toString());
		System.out.println(StringUtils.leftPad("7", 2, "0"));

	}

	public static void customCountedString() {
		List<String> ls = Arrays.asList("aa", "aa", "aa", "aa", "aa");
		for (String item : ls) {
			CustomCountedString ccs = new CustomCountedString(item);
			System.out.println(ccs.toString());
		}
		System.out.println(ls.get(0).equals(ls.get(1)));
	}

	public static void stringHashCode() {
		String hashString = "do you like no sql";
		String hashString2 = "do you like no sql";
		System.out.println(hashString + "=>" + hashString.hashCode());
		System.out.println(hashString2 + "=>" + hashString2.hashCode());
	}

	public static void simpleHashMapCustom() {
		SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<Integer, String>();
		hashMap.put(1, "david");
		hashMap.put(2, "mongodb");
		hashMap.put(3, "redis");
		hashMap.put(4, "cancarrrdes");
		hashMap.put(5, "hellworld");
		System.out.println(hashMap.toString());
		String removeElement = hashMap.remove(3);
		System.out.println("after remove " + removeElement);
		System.out.println(hashMap.toString());
		hashMap.clear();
		System.out.println("after clear " + hashMap.toString());
	}

	public static void simpleHashMapDemo() {

		long start = System.currentTimeMillis();
		SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<String, String>();
		simpleHashMap.putAll(new MapGenerator().generateRandomMapData(number));
		System.out.println(simpleHashMap.toString());
		System.out.println("耗时："
				+ String.valueOf(System.currentTimeMillis() - start) + "����");
		System.out.println("hashAddress ConfictCount"
				+ simpleHashMap.getHashConflictCount() + "\n"
				+ simpleHashMap.getHashConflictExceptions());
		System.out.println("GetExistMap：" + simpleHashMap.getExistMaps());
	}

	public static void slowMapDemo() {
		long start = System.currentTimeMillis();
		SlowMap<String, String> slowMap = new SlowMap<String, String>();
		slowMap.putAll(new MapGenerator().generateRandomMapData(number));
		System.out.println(slowMap.toString());
		System.out.println("耗时："
				+ String.valueOf(System.currentTimeMillis() - start) + "����");
	}

	public static void mapGenerator() {
		MapGenerator mg = new MapGenerator();
		System.out.println(mg.generateRandomMapData(10));
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	}

	public static void linkedHashMap() {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(
				new CountedMapData(9));
		System.out.println(lhm.toString());
		lhm = new LinkedHashMap<Integer, String>(16, 0.75f, true);
		lhm.putAll(new CountedMapData(9));
		System.out.println(lhm.toString());
		for (int i = 0; i < 6; i++) {
			lhm.get(i);
		}
	}

	public static void testTime() {
		Calendar c = Calendar.getInstance();
		c.set(2013, 6, 11);
		Calendar cc = Calendar.getInstance();
		cc.setTimeInMillis(Long.parseLong("1380462865661"));
		System.out.println(cc.getTime());
	}

	public static void searchFileConditions(String filepath) {
		List<File> condionFiles = new ArrayList<File>();
		File file = new File(filepath);
		File[] files = file.listFiles();
		for (File item : files) {
			if (!item.isDirectory()) {
				continue;
			} else {
				Calendar date = Calendar.getInstance();
				date.setTimeInMillis(file.lastModified());
				System.err.println(file.lastModified());
				Calendar lastDate = Calendar.getInstance();
				lastDate.set(2013, 6, 12);
				if (date.compareTo(lastDate) > 0) {
					condionFiles.add(file);
				}
			}
		}

		for (File conFile : condionFiles) {
			StrBuilder sb = new StrBuilder();
			sb.appendln("Is Directory: " + conFile.isDirectory());
			sb.appendln("Name: " + conFile.getName());
			System.out.println(sb.toString());
		}
	}

	public static void directoryClassDemo() {
		String path = "G:\\照片";
		// String path = ".";
		System.out
				.println(Directory.TreeInfo.walk(new File(path), "Thumbs.db"));
	}

	public static void sortedDirList() {
		SortedDirList sdDir = new SortedDirList(".");
		System.out.println(sdDir.list());
		System.out.println(String.format("size：%d", sdDir.getCount()));
		System.out.println(sdDir.list("\\w+.txt"));
		System.out.println(String.format("size：%d", sdDir.getCount()));
	}

	public static void listAllFiles(String path) {
		List<File> files = new ArrayList<File>();
		File file = new File(path);
		for (File item : file.listFiles()) {
			if (item.isDirectory()) {
				listAllFiles(item.getPath());
			} else {
				if (item.isFile()) {
					files.add(item);
				}
			}
		}
		System.out.println(files.toString());
	}
}
