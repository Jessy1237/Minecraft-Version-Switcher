package com.Jessy1237.renamer;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RenamerMac {
	public static String userHome = System.getProperty("user.home");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft/bin");
	public static File file18 = new File(dir, "/1.8.jar"); 
	public static File file17 = new File(dir, "/1.7.jar");
	public static File file1 = new File(dir, "/1.0.jar");
	public static File fileJar = new File(dir, "/minecraft.jar");
    static TextWriter Mac;
	
	public RenamerMac() {
		Mac = new TextWriter();
	}
	
	public void Mac18() throws IOException {
		Opener.Jar = "1.8";
		if (Opener.mcver.equals("1.7")) {
			fileJar.renameTo(file17);
		}
		if(Opener.mcver.equals("1.0")){
			fileJar.renameTo(file1);
		}
		boolean exists = (file18).exists();
		if (!exists) {
			if (Opener.mcver.equals("1.8")) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
				if (Opener.mcver.equals("1.7")) {
					file17.renameTo(fileJar);
					Mac.Mactxt17();
				}
				if(Opener.mcver.equals("1.0")){
					file1.renameTo(fileJar);
					Mac.Mactxt1();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Miss();
				if (Opener.mcver.equals("1.7")) {
					file17.renameTo(fileJar);
					Mac.Mactxt17();
				}
				if(Opener.mcver.equals("1.0")){
					file1.renameTo(fileJar);
					Mac.Mactxt1();
				}
			}
		} else {
			boolean success1 = file18.renameTo(fileJar);
			if (!success1) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				if (Opener.mcver.equals("1.7")) {
					file18.renameTo(fileJar);
					Mac.Mactxt17();
				}
				if(Opener.mcver.equals("1.0")){
					file1.renameTo(fileJar);
					Mac.Mactxt1();
				}
			} else {
				Mac.Mactxt18();
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}
	
	
	public void Mac17() throws IOException {
		Opener.Jar = "1.7";
		if (Opener.mcver.equals("1.8")) {
			fileJar.renameTo(file18);
		}
		if(Opener.mcver.equals("1.0")){
			fileJar.renameTo(file1);
		}
		boolean exists = (file17).exists();
		if (!exists) {
			if (Opener.mcver.equals("1.7")) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			} else {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Miss();
				if (Opener.mcver.equals("1.8")) {
					file18.renameTo(fileJar);
					Mac.Mactxt18();
				}
				if(Opener.mcver.equals("1.0")){
					file1.renameTo(fileJar);
					Mac.Mactxt1();
				}
			}
		} else {
			boolean success1 = file17.renameTo(fileJar);
			if (!success1) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				if (Opener.mcver.equals("1.8")) {
					file18.renameTo(fileJar);
					Mac.Mactxt18();
				}
				if(Opener.mcver.equals("1.0")){
					file1.renameTo(fileJar);
					Mac.Mactxt1();
				}
			} else {
				Mac.Mactxt17();
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}

	public void Mac1() throws IOException {
		Opener.Jar = "1.0";
		if(Opener.mcver.equals("1.8")){
			fileJar.renameTo(file18);
		}
		if(Opener.mcver.equals("1.7")){
			fileJar.renameTo(file17);
		}
		boolean exists = (file1).exists();
		if (!exists) {
			if (Opener.mcver.equals("1.0")) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			} else {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Miss();
				if (Opener.mcver.equals("1.8")) {
					file18.renameTo(fileJar);
					Mac.Mactxt18();
				}
				if (Opener.mcver.equals("1.7")) {
					file17.renameTo(fileJar);
					Mac.Mactxt17();
				}
			}
		} else {

			boolean success1 = file1.renameTo(fileJar);
			if (!success1) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				if (Opener.mcver.equals("1.8")) {
					file18.renameTo(fileJar);
					Mac.Mactxt18();
				}
				if (Opener.mcver.equals("1.7")) {
					file17.renameTo(fileJar);
					Mac.Mactxt17();
				}
			} else {
				Mac.Mactxt1();
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}
}
