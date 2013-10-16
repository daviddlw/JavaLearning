package david.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.text.StrBuilder;

public class TextFile extends ArrayList<String> {

	public TextFile(String path, String splitter) {
		// TODO Auto-generated constructor stub
		super(Arrays.asList(read(path).split(splitter)));
	}

	public TextFile(String path) {
		// TODO Auto-generated constructor stub
		this(path, "\n");
	}

	/*
	 * ¶ÁÈ¡ÎÄ¼þ
	 */
	public static String read(String filename) {
		StrBuilder sb = new StrBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					filename).getAbsoluteFile()));
			String s;
			try {
				while ((s = in.readLine()) != null) {
					sb.appendln(s);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	public static void write(String filename, String text) {
		try {
			PrintWriter out = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	public void write(String filename) {
		try {
			PrintWriter out = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				for (String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
