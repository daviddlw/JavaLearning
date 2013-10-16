package david.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFile {
	/*
	 * 返回文件的字节流数组
	 */
	public static byte[] read(File file) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				file));
		try {
			byte[] buffers = new byte[in.available()];
			in.read(buffers);
			return buffers;
		} finally {
			// TODO: handle exception
			in.close();
		}
	}
	
	/*
	 * 重载根据文件路径名获取相应字节流数组
	 */
	public static byte[] read(String filepath) throws IOException {
		return read(new File(filepath).getAbsoluteFile());
	}
}
