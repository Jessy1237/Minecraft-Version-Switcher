package com.Jessy1237.renamer;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileView;

public class main{
	
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft/bin");
	public static File dir = new File(userHome,
			"/Library/Application Support/minecraft/bin");
	public static File Wintxt = new File(Windir, "/.mcversion.txt");
	public static File Mactxt = new File(dir, "/mcversion.txt");

	public static void b() throws IOException{
		InputCurrentJarGUI m = new InputCurrentJarGUI();
		Opener.mcver();
		if(Opener.osName.contains("win")){
			if(!Wintxt.exists()){
				Wintxt.createNewFile();
				JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
				TextMaker.txt();
				Opener.mcver();
			}
		}else{
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
