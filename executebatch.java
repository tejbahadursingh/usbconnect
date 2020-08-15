import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class executebatch {
	private static String OS = System.getProperty("os.name").toLowerCase();

	public static void main(String[] args) {
		try {

			if (isWindows()) {
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", "MyBatch.bat");
//				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", "wmic logicaldisk get description,name");
				pb.start();
//				Process process = pb.start();

//				InputStream is = process.getInputStream();
//				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//		
//				String line;
//				while ((line = reader.readLine()) != null) {
//			   		System.out.println(line);
//				}
			}

			if (isMac()) {
				// TODO get input from mac user about USB location to read/writes
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

}
