package david.javaio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OSExecute {
	
	/*
	 * 使用list方式显示
	 */
	public static List<String> commandByList(String command) {
		boolean err = false;
		List<String> ls = new ArrayList<String>();
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String result;
			while ((result = results.readLine()) != null) {
				ls.add(result);
			}
			BufferedReader errors = new BufferedReader(new InputStreamReader(
					process.getErrorStream()));
			String error;
			while ((error = errors.readLine()) != null) {
				ls.add(String.format("【%s】", error));
			}

			results.close();
			errors.close();
		} catch (Exception e) {
			// TODO: handle exception
			if (!command.startsWith("CMD /C" + command)) {
				command("CMD /C " + command);
			} else {
				throw new RuntimeException(e);
			}
		}
		if (err) {
			throw new OSExecuteException("Errors executing " + command);
		}
		return ls;
	}

	/*
	 * 命令
	 */
	public static void command(String command) {
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String result;
			while ((result = results.readLine()) != null) {
				System.out.println(result);
			}
			BufferedReader errors = new BufferedReader(new InputStreamReader(
					process.getErrorStream()));
			String error;
			while ((error = errors.readLine()) != null) {
				System.err.println(error);
				err = true;
			}

			results.close();
			errors.close();
		} catch (Exception e) {
			// TODO: handle exception
			if (!command.startsWith("CMD /C" + command)) {
				command("CMD /C " + command);
			} else {
				throw new RuntimeException(e);
			}
		}
		if (err) {
			throw new OSExecuteException("Errors executing " + command);
		}
	}
}
