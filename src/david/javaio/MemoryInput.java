package david.javaio;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
	
	/*
	 * read single character
	 */
	public static String readBySingleChar(String path) throws IOException {
		StringReader sr = new StringReader(BufferedInputFile.read(path));
		StringBuilder sb = new StringBuilder();
		int c;
		while ((c = sr.read()) != -1) {
			String item = String.valueOf((char) c);
			if (!item.isEmpty() && item != "\r" && item != "\n")
				sb.append(item + "_");
		}
		return sb.substring(0, sb.toString().length() - 1);
	}
}
