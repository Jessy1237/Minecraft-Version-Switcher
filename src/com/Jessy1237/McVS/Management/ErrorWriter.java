package com.Jessy1237.McVS.Management;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.Jessy1237.McVS.McVS;

public class ErrorWriter {

	public static String userHome = System.getProperty("user.home");
	public static File eTxt = new File(userHome, "Desktop/McVS Error Log.txt");
	public static Properties prop2 = new Properties();
	
	public static void Un() throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Unable to switch the jar " + McVS.Jar.getName() +" with " + McVS.mcver.getName() +  " Was Your Minecraft Open?");
		out.flush();
		out.close();
	}
	
	public static void Miss() throws IOException{
		if(!eTxt.exists()){
		eTxt.createNewFile();
	}
	FileOutputStream out = new FileOutputStream(eTxt);
	prop2.store(out, "Your " + McVS.Jar.getName() + " Jar is missing, have you deleted it?");
	out.flush();
	out.close();
	}
	
	public static void JAS() throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Your current Jar is already set to "
				+ McVS.Jar.getName() + ".");
		out.flush();
		out.close();
	}
	
	public static void FMiss(File folder) throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Unable to switch the " + McVS.Jar.getName() + " mod folder with the minecraft mod folder. The folder is missing, Try making this folder Here: " + folder.getAbsolutePath());
		out.flush();
		out.close();
	}
	
	public static void FUn() throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Unable to switch the " + McVS.Jar.getName() + " mod folder!");
		out.flush();
		out.close();
	}
}
