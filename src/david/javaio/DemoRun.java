package david.javaio;

import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.time.DateUtils;

import david.deepInCollection.CountedMapData;
import david.deepInCollection.CustomCountedString;
import david.deepInCollection.MapGenerator;
import david.deepInCollection.SimpleHashMap;
import david.deepInCollection.SlowMap;
import david.deepInCollection.SortedDirList;
import david.util.StringUtil;

public class DemoRun {

	private static int number = 1000;

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
