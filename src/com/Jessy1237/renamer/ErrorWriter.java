package com.Jessy1237.renamer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ErrorWriter {

	public static String userHome = System.getProperty("user.home");
	public static File eTxt = new File(userHome, "Desktop/McVS Error Log.txt");
	public static Properties prop2 = new Properties();
	
	public static void Un() throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Unable to switch the jar " + Opener.Jar +" with " + Opener.mcver +  " Was Your Minecraft Open?");
		out.flush();
		out.close();
	}
	
	public static void Miss() throws IOException{
		if(!eTxt.exists()){
		eTxt.createNewFile();
	}
	FileOutputStream out = new FileOutputStream(eTxt);
	prop2.store(out, "Your " + Opener.Jar + " Jar is missing, have you deleted it?");
	out.flush();
	out.close();
	}
	
	public static void JAS() throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Your current Jar is already set to "
				+ Opener.Jar + ".");
		out.flush();
		out.close();
	}
	
	public static void FMiss(File folder) throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Unable to switch the " + Opener.Jar + " mod folder with the minecraft mod folder. The folder is missing, Try making this folder Here: " + folder);
	}
	
	public static void FUn() throws IOException{
		if(!eTxt.exists()){
			eTxt.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(eTxt);
		prop2.store(out, "Unable to switch the " + Opener.Jar + " mod folder!");
	}
}
