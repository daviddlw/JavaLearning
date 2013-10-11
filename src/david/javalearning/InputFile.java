package david.javalearning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {

	private BufferedReader in;
	public static String FILE_DEMO_PATH = "J:\\¿ª·¢\\Java\\IODemo.txt";

	public InputFile() {
		// TODO Auto-generated constructor stub
	}

	public InputFile(String fname) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fname));
//			throw new Exception("test");
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				in.close();
			} catch (IOException e2) {
				// TODO: handle exception
				System.out.println("in.close() unsuccessfully");
			}
			throw e;
		} finally {
			// Needn't to do anything
		}
	}

	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}

		return s;
	}

	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() successfully");
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("in.close() failed");
		}

	}
}
