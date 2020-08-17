import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;


public class executebatch {
	private static String OS = System.getProperty("os.name").toLowerCase();

	public static void main(String[] args) {
		try {
//			String userid = args[0];
			String userid = "45";
//			String accessToken = args[1];
			String accessToken = "57c00e070f1268b3d0c3e333aaa3992e17f2b1158d36333340a7977cdf9edcf0";
//			String keysGenerationAllowedFlag = args[2];
			String keysGenerationAllowedFlag = "Y";
			if(!userid.isEmpty() && !accessToken.isEmpty()) {
				if (isWindows()) {
//					ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start MyBatch.bat", userid, accessToken);
					ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start ext.bat", userid, accessToken, keysGenerationAllowedFlag);
//					ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", "wmic logicaldisk get description,name");
					pb.start();
//					Process process = pb.start();

//					InputStream is = process.getInputStream();
//					BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//			
//					String line;
//					while ((line = reader.readLine()) != null) {
//				   		System.out.println(line);
//					}
				}

				if (isMac()) {
					// TODO get input from mac user about USB location to read/writes
				}
			} else {
				// TODO Need to confirm if userid is not provided then what needs to be done
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
