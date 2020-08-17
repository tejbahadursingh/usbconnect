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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;


public class PerformOperation {
	private static String keyPath;
	private static String keyFullName;
	
	public static void main(String[] args) {
		try {
			
//			makeHttpRequest("121414","2343434");
			
			final String directory = "privatekeys";
			String usbDrive  = args[0];
			String userId = args[1];
			String accessToken = args[2];
			String keysGenerationAllowedFlag = args[3];
			String keyFileExtension = ".key";
			
			keyPath = usbDrive + File.separator + directory;
			
			keyFullName = usbDrive + File.separator + directory + File.separator + userId + keyFileExtension;
			
			System.out.println(keysGenerationAllowedFlag);
			if(keysGenerationAllowedFlag == "Y") {
				// TODO process to perform private key generation
				generateKeyPair(userId, accessToken);
			}else {
				// TODO process to perform user login to EMR
//				emrLogin();
			}
			
			
			System.out.println(keyFullName);
			
			
 		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void generateKeyPair(String userid, String accessToken) throws IOException {
//		File file = new File(keyPath);
//		boolean fileExists = file.exists();
//		if(!fileExists) {
//			boolean canWrite = file.canWrite();
//			boolean dirCreated = file.mkdir();
//			if(!dirCreated) {
//				// TODO Write operation to be performed if directory creation fails
//				System.out.println("directory No created");
//			}
//		}
		
//		String userid = "45";
//		String accessToken = "57c00e070f1268b3d0c3e333aaa3992e17f2b1158d36333340a7977cdf9edcf0";
		String url = "http://shadoboxbirdrockusers.local/api2/generate-key-emr-data";
		String response = makeHttpRequest(userid, accessToken, url);
		System.out.println(response);
//		String privateKey = "??V??\\bE?F��??@??7=???D�a?_��\\f4?�?Y�?�o;?\\\\��7d?7?w??�MLs?\\r@\\t???/";
//		writeInUSB(keyFullName, privateKey);
	}
	
	public static void emrLogin() throws FileNotFoundException {
		readFromUSB(keyFullName);
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
	
	
	
//	@SuppressWarnings("unchecked")
	public static String makeHttpRequest(String userid, String accessToken, String url) throws IOException{
//		String url = "http://shadoboxbirdrockusers.local/api2/generate-key-emr-data";
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

		connection.setRequestMethod("POST");
		connection.addRequestProperty("content-type", "application/json; utf-8");
		connection.setRequestProperty("Accept", "application/json");
		connection.setDoOutput(true);
		
		JSONObject postData = new JSONObject();
		Map innerObject = new LinkedHashMap(2);
		innerObject.put("access_token", accessToken);
		innerObject.put("user_id", userid);
		
//		JSONObject innerObject = new JSONObject();
//		innerObject.put("access_token", accessToken);
//		innerObject.put("user_id", userid);
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
	
	    return response.toString();
	}
}
