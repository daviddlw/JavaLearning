package david.javanio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileCompress {
	private static String filename = "goal.txt";
	private static String gzipname = "gzip.gz";
	/*
	 * gzip方式压缩单文件
	 */
	public static void gzipCompress() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			BufferedOutputStream out = new BufferedOutputStream(
					new GZIPOutputStream(new FileOutputStream(gzipname)));

			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}

			in.close();
			out.close();

			BufferedReader resultIn = new BufferedReader(new InputStreamReader(
					new GZIPInputStream(new FileInputStream(gzipname))));
			String c;
			while ((c = resultIn.readLine()) != null) {
				System.out.println(c);
			}

			resultIn.close();

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
