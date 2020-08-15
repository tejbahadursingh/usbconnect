import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PerformOperation {
	
	
	public static void main(String[] args) {
		try {
			final String directory = "privatekeys";
			String usbDrive  = args[0];
			String userId = args[1];
			String keyFileExtension = ".key";
			
			String keyFullName = usbDrive + File.separator + directory + File.separator + userId + keyFileExtension;
			
			File file = new File(usbDrive + File.separator + directory );
			boolean fileExists = file.exists();
			if(!fileExists) {
				boolean canWrite = file.canWrite();
				boolean dirCreated = file.mkdir();
				if(!dirCreated) {
					// TODO Write operation to be performed if directory creation fails
					System.out.println("directory No created");
				}
			}		
			FileWriter myWriter = new FileWriter(keyFullName);
			myWriter.write("This is a wrte from java");
			myWriter.close();
			
			File myFile = new File(keyFullName);
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
 		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
