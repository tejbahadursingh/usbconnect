package com.usb;

import java.io.IOException;
import java.net.URISyntaxException;

import com.profesorfalken.jpowershell.PowerShell;

public class App {
	public static void main (String [] args) throws IOException, InterruptedException, URISyntaxException{
		String command = "Get-WmiObject -Class Win32_Volume | ? { $_.SerialNumber -eq '3624566224' } | select Name -ExpandProperty Name";
		String output = PowerShell.executeSingleCommand(command).getCommandOutput();
		System.out.println(output);
	}
}
