package com.usb;

import java.io.FileWriter;
//package com.usb;

import java.io.FileWriter;
import java.io.IOException;

public class UsbWindows {
	public static void main(String[] args) {

		try {
			//FileWriter myWriter = new FileWriter(args[0]+":\\22.txt");
			FileWriter myWriter = new FileWriter("Z:\\22.txt");
			myWriter.write("Add 1111 line for testing purpose");
			myWriter.close();

			/*
			 * FileWriter writer = new FileWriter("D:\\MyFile.txt", true);
			 * writer.write("Hello World"); writer.write("\r\n"); // write new line
			 * writer.write("Good Bye!"); writer.close();
			 */

			//Scanner myReader = new Scanner(myFile);
			//while (myReader.hasNextLine()) {
			//String data = myReader.nextLine();
			//System.out.println(data);
			//}
			//myReader.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
