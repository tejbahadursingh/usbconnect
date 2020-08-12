package com.usb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;

import java.lang.*;

public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        
//    	Usb4JavaHigh usb4java = new Usb4JavaHigh();
////		UsbDevice usbDevice = usb4java.findDevice((short) (0x046D), (short) (0xC31C));
//		UsbDevice usbDevice = usb4java.findDevice((short) (2385), (short) (5733));
//		if(usbDevice != null) {
//			System.out.println("USB device found");
//			usb4java.readMessage(usb4java.getDeviceInterface(usbDevice, 0), 0);
//			usb4java.sendBulkMessage(usb4java.getDeviceInterface(usbDevice, 0), "This is", 0);
//		}else {
//			System.out.println("No USB device found");
//		}
		
    	FileSystemView fsv = FileSystemView.getFileSystemView();
       
        File[] drives = File.listRoots();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                System.out.println("Drive Letter: " + aDrive);
                System.out.println("\tType: " + fsv.getSystemTypeDescription(aDrive));
                System.out.println("\tTotal space: " + aDrive.getTotalSpace());
                System.out.println("\tFree space: " + aDrive.getFreeSpace());
                System.out.println();
            }
        }
    	
//		try {
//			FileWriter myWriter = new FileWriter("E:\\2345.txt");
//			myWriter.write("This is a wrte from java");
//			myWriter.close();
//			
//			File myFile = new File("E:\\1234.txt");
//			Scanner myReader = new Scanner(myFile);
//			while (myReader.hasNextLine()) {
//		        String data = myReader.nextLine();
//		        System.out.println(data);
//		      }
//		      myReader.close();
// 		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UsbServices services = UsbHostManager.getUsbServices();
//			UsbHub rootHub = services.getRootUsbHub();
//			List<UsbDevice> devices = rootHub.getAttachedUsbDevices();
//			
//			if (devices.size() > 0) {
//				System.out.println("USB devices found.");
//			} else {
//				System.out.println("No USB devices found.");
//			}
//			for (UsbDevice device : devices) {
//				UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
//				if(desc.idVendor() == (short)(2385) && desc.idProduct() == (short)(5733)) {
//					
//					System.out.println("\tvendor Id :: " + desc.idVendor());
//					System.out.println("\tvendor product :: " + desc.idProduct());
////					System.out.println("\tProduct String :: " + device.getProductString());
////					System.out.println("\tManufacturer String :: " + device.getManufacturerString());
////					System.out.println("\tSerial Number :: " + device.getSerialNumberString());
//				}
//				
//				
//			} 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        
    }
}
