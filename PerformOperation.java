import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class PerformOperation {
	
	
	public static void main(String[] args) {
		try {
			
//			makeHttpRequest("121414","2343434");
			
			final String directory = "privatekeys";
			String usbDrive  = args[0];
			String userId = args[1];
			String accessToken = args[2];
			String keysGenerationAllowedFlag = args[3];
			String keyFileExtension = ".key";
			String privateKey = "??V??\\bE?F��??@??7=???D�a?_��\\f4?�?Y�?�o;?\\\\��7d?7?w??�MLs?\\r@\\t???/";
			
			String keyFullName = usbDrive + File.separator + directory + File.separator + userId + keyFileExtension;
			
			System.out.println(keyFullName);
			
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
			writeInUSB(keyFullName, privateKey);
			
			readFromUSB(keyFullName);
 		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void generateKeyPair() {
		
	}
	
	public static void emrLogin() {
		
	}
	
	public static void writeInUSB(String keyFullName, String privateKey) throws IOException {
		FileWriter myWriter = new FileWriter(keyFullName);
		myWriter.write(privateKey);
		myWriter.close();
	}
	
	public static void readFromUSB(String keyFullName) throws FileNotFoundException {
		File myFile = new File(keyFullName);
		Scanner myReader = new Scanner(myFile);
		while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	      myReader.close();
	}
	
	
	
	public static void makeHttpRequest(String userid, String accessToken, String url) throws IOException{
//		String url = "http://shadoboxbirdrockusers.local/api2/generate-key-emr-data";
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

		connection.setRequestMethod("POST");
		connection.addRequestProperty("content-type", "application/json; utf-8");
		connection.setRequestProperty("Accept", "application/json");
		connection.setDoOutput(true);
		
		JSONObject postData = new JSONObject();
		
		JSONObject innerObject = new JSONObject();
		innerObject.put("access_token", "81ee1c3a46d3f8827fc65336e7c10280ac7767713d6f8e8af61da1d282becd28");
		innerObject.put("user_id", "1190");
		postData.put("object", innerObject);
		
		System.out.println(postData);
		
//		OutputStream os = connection.getOutputStream();
//	    byte[] input = postData.toString().getBytes("utf-8");
//	    os.write(input, 0, input.length);			
		
		
	    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
	    wr.write(postData.toString());
	    wr.flush();
		
		int responseCode = connection.getResponseCode();
		if(responseCode == 200){
			System.out.println("POST was successful.");
			System.out.println(connection.getResponseMessage());
		}
		else if(responseCode == 401){
			System.out.println("Wrong password.");
			System.out.println(connection.getResponseMessage());
		}
		System.out.println(connection.getResponseMessage());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
	    StringBuilder response = new StringBuilder();
	    String responseLine = null;
	    while ((responseLine = br.readLine()) != null) {
	        response.append(responseLine.trim());
	    }
	    System.out.println(response.toString());
	
		
	}
}
