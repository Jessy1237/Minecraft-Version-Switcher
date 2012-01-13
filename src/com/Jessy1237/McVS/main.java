package com.Jessy1237.McVS;

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
	public static File Winfolder11 = new File(Windir, "/mods 1-1");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft");
	public static File fileFolder = new File(dir, "/mods");
	public static File folder18 = new File(dir, "/mods 1-8");
	public static File folder17 = new File(dir, "/mods 1-7");
	public static File folder1 = new File(dir, "/mods 1-0");
	public static File folder11 = new File(dir, "/mods 1-1");
	public static File Wintxt = new File(Windir, "/bin/.mcversion.txt");
	public static File Mactxt = new File(dir, "/bin/mcversion.txt");
	public static int c = 0;
	public static String msg = "";

	public static void b() throws IOException{
		InputCurrentJarGUI m = new InputCurrentJarGUI();
		McVS.mcver();

		if(!Wintxt.exists() && McVS.osName.contains("win")){
			Wintxt.createNewFile();
			JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
			TextMaker.txt();
			McVS.mcver();
		}
		if(!Mactxt.exists() && McVS.osName.contains("mac")){
			Mactxt.createNewFile();
			JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
			TextMaker.txt();
			McVS.mcver();
		}

	if(McVS.mcver == null){
		m.setVisible(true);
	}else{
		InputCurrentJarGUI.a();
	}
		if(McVS.osName.contains("win")){
				if(!McVS.mcver.equals("1.8") && !(Winfolder18.exists())){
					Winfolder18.mkdir();
					msg = msg + "1.8";
					c++;
				}
				if(!McVS.mcver.equals("1.7") && !(Winfolder17.exists())){
					Winfolder17.mkdir();
					if(c > 0){
						msg = msg + ", 1.7";
					}else{
						msg = msg + "1.7";
					}
					c++;
				}
				if(!McVS.mcver.equals("1.0") && !(Winfolder1.exists())){
					Winfolder1.mkdir();
					if(c > 0){
						msg = msg + ", 1.0";
					}else{
						msg = msg + "1.0";
					}	
					c++;
				}
				if(!McVS.mcver.equals("1.1") && !(Winfolder11.exists())){
					Winfolder11.mkdir();
					if(c > 0){
						msg = msg + ", 1.1";
					}else{
						msg = msg + "1.1";
					}
					c++;
				}
				if(c > 0){
					JOptionPane.showMessageDialog(null, "New mod folder/s '" + msg +"', was/were created at minecraft directory, The current mod folder is for the " + McVS.mcver + " jar.", "Minecraft Version Switcher", 1);
				}
		}else{
			if(!McVS.mcver.equals("1.8") && !(folder18.exists())){
				folder18.mkdir();
				msg = msg + "1.8";
				c++;
			}
			if(!McVS.mcver.equals("1.7") && !(folder17.exists())){
				folder17.mkdir();
			if(c > 0){
				msg = msg + ", 1.7";
			}else{
				msg = msg + "1.7";
			}
				c++;
			}
			if(!McVS.mcver.equals("1.0") && !(folder1.exists())){
				folder1.mkdir();
				if(c > 0){
					msg = msg + ", 1.0";
				}else{
					msg = msg + "1.0";
				}
				c++;
			}
			if(!McVS.mcver.equals("1.1") && !(folder1.exists())){
				folder11.mkdir();
				if(c > 0){
					msg = msg + ", 1.1";
				}else{
					msg = msg + "1.1";
				}
				c++;
			}
			if(c > 0){
				JOptionPane.showMessageDialog(null, "New mod folder/s '" + msg + "', was/were created at minecraft directory, The current mod folder is for the " + McVS.mcver + " jar.", "Minecraft Version Switcher", 1);
			}
		}
		McVS o = new McVS();
		o.setVisible(true);
	}

	public static void main(String[] args) throws Exception{
		b();
	}
}
