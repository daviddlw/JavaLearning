package david.javalearning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemo {
	private static final String READ_FILEPATH = "G:\\开发\\Java\\IODemo.txt";
	private static final String WRITE_FILEPATH = "G:\\开发\\Java\\IOWriteDemo.txt";

	public IODemo() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 简单的IO读取文件
	 */
	public static void readFileSample(boolean hasBreak) {
		try

		{
			BufferedReader bReader = new BufferedReader(new FileReader(
					READ_FILEPATH));

			StringBuilder sb = new StringBuilder();
			String contentString = bReader.readLine();
			do {
				if (hasBreak) {
					sb.append(contentString + ",");
				} else {
					sb.append(contentString + "\r\n");
				}

				contentString = bReader.readLine();
			} while (contentString != null);

			System.out.println(sb.toString().substring(0,
					sb.toString().length() - 1));
			bReader.close();
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println(e.toString());
		}
	}

	/*
	 * 简单IO写文件
	 */
	public static void writeFileSample() {
		try {
			String contentString = "\r\nThis is append content";

			File file = new File(WRITE_FILEPATH);
			if (!file.exists())
				file.createNewFile();

			BufferedWriter bWriter = new BufferedWriter(new FileWriter(
					WRITE_FILEPATH, true));

			bWriter.append(contentString);
			bWriter.flush();

			// bWriter.write(contentString);
			// bWriter.newLine();
			bWriter.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void clearUp() {
		try {
			InputFile iFile = new InputFile(InputFile.FILE_DEMO_PATH);			
			try {
				String s;
				int i = 1;
				while ((s = iFile.getLine()) != null) {
					System.out.println(s);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Caught Exception in main function.");
				e.printStackTrace(System.out);
			} finally {
				iFile.dispose();
			}
		} catch (Exception e) {
			System.out.format("InputFile construction failed. => %s",
					e.getMessage());
		}
	}
}
