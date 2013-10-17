package david.javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.text.StrBuilder;

public class BufferedInputFile {
	/*
	 * ����·����ȡ��Ӧ�ļ�
	 */
	public static String read(String filepath) throws IOException {
		List<String> ls = read(new File(filepath));
		StrBuilder sb = new StrBuilder();
		for (String item : ls) {
			sb.appendln(item);
		}

		return sb.toString();
	}

	/*
	 * �����������Ԫ��
	 */
	public static List<String> upperArrayList(String filepath)
			throws IOException {
		List<String> ls = read(new File(filepath));
		for (int i = 0; i < ls.size(); i++) {
			String item = ls.get(i);
			ls.set(i, item.toUpperCase());
		}
		return ls;
	}

	/*
	 * ����pattern��Ѱָ�����
	 */
	public static List<String> searchedList(String filepath, String pattern)
			throws IOException {
		List<String> ls = read(new File(filepath));
		List<String> resultLs = new ArrayList<String>();
		for (String item : ls) {
			if (item.contains(pattern)) {
				resultLs.add(item);
			}
		}

		return resultLs;
	}

	/*
	 * �������list�ļ�
	 */
	public static List<String> readByReverse(String filepath)
			throws IOException {
		List<String> ls = read(new File(filepath));
		Collections.reverse(ls);
		return ls;
	}

	public static List<String> readToList(File file) throws IOException {
		return read(file);
	}

	private static List<String> read(File file) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String s;
		List<String> ls = new LinkedList<String>();
		while ((s = bufferedReader.readLine()) != null) {
			if (!s.trim().isEmpty())
				ls.add(s);
		}

		bufferedReader.close();

		return ls;
	}
}
