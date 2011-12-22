package com.Jessy1237.renamer;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class main{
	
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft");
	public static File WinfileFolder = new File(Windir, "/mods");
	public static File Winfolder18 = new File(Windir, "/mods 1-8");
	public static File Winfolder17 = new File(Windir, "/mods 1-7");
	public static File Winfolder1 = new File(Windir, "/mods 1-0");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft");
	public static File fileFolder = new File(dir, "/mods");
	public static File folder18 = new File(dir, "/mods 1-8");
	public static File folder17 = new File(dir, "/mods 1-7");
	public static File folder1 = new File(dir, "/mods 1-0");
	public static File Wintxt = new File(Windir, "/bin/.mcversion.txt");
	public static File Mactxt = new File(dir, "/bin/mcversion.txt");
	public static int c = 0;

	public static void b() throws IOException{
		InputCurrentJarGUI m = new InputCurrentJarGUI();
		Opener.mcver();
		if(Opener.osName.contains("win")){
			if(Winfolder18.exists() && Winfolder17.exists() && Winfolder1.exists()){
			}else{
				if(!Opener.mcver.equals("1.8") && !(Winfolder18.exists())){
					Winfolder18.mkdir();
					c = 1;
				}
				if(!Opener.mcver.equals("1.7") && !(Winfolder17.exists())){
					Winfolder17.mkdir();
					c = 1;
				}
				if(!Opener.mcver.equals("1.0") && !(Winfolder1.exists())){
					Winfolder1.mkdir();
					c = 1;
				}
				if(c == 1){
					JOptionPane.showMessageDialog(null, "New mod folders created at minecraft directory, The current mod folder is for the " + Opener.mcver + " jar.", "Minecraft Version Switcher", 1);
				}
			}
			if(!Wintxt.exists()){
				Wintxt.createNewFile();
				JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
				TextMaker.txt();
				Opener.mcver();
			}
		}else{
			if(folder18.exists() && folder17.exists() && folder1.exists()){
			}else{
				if(!Opener.mcver.equals("1.8") && !(folder18.exists())){
					folder18.mkdir();
					c = 1;
				}
				if(!Opener.mcver.equals("1.7") && !(folder17.exists())){
					folder17.mkdir();
					c = 1;
				}
				if(!Opener.mcver.equals("1.0") && !(folder1.exists())){
					folder1.mkdir();
					c = 1;
				}
				if(c == 1){
					JOptionPane.showMessageDialog(null, "New mod folders created at minecraft directory, The current mod folder is for the " + Opener.mcver + " jar.", "Minecraft Version Switcher", 1);
				}
			}
			if(!Mactxt.exists()){
				Mactxt.createNewFile();
				JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
				TextMaker.txt();
				Opener.mcver();
			}
		}

		if(Opener.mcver == null){
			m.setVisible(true);
		}else{
			InputCurrentJarGUI.a();
			Opener o = new Opener();
			o.setVisible(true);
		}
	}

	public static void main(String[] args) throws Exception{
		b();
	}
}
