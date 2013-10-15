package david.javaio;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {

	public static void formattedMemoryInput(String path) throws IOException {
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(
				BufferedInputFile.read(path).getBytes()));

		while (in.available() > 0) {
			System.out.print((char) in.readByte());
		}
	}
}
