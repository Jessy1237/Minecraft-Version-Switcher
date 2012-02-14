package com.Jessy1237.McVS;

import java.io.*;

public class TextWriter {

	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome, "/AppData/roaming/.minecraft/bin");
	public static File Wintxt = new File(Windir, "/.mcversion.txt");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft/bin");
	public static File Mactxt = new File(dir, "/mcversion.txt");
	
	public void write(String ver) throws IOException {
		if(McVS.osName.contains("win")){
			FileOutputStream out = new FileOutputStream(Wintxt);
			McVS.prop.put("jar", ver);
			McVS.prop.store(out, "Do Not Edit This File!");
			out.flush();
			out.close();
		}
		if(McVS.osName.contains("mac")){
			FileOutputStream out = new FileOutputStream(Mactxt);
			McVS.prop.put("jar", ver);
			McVS.prop.store(out, "Do Not Edit This File!");
			out.flush();
			out.close();
		}
	}
}