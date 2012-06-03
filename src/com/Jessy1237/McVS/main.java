package com.Jessy1237.McVS;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.Jessy1237.McVS.GUI.InputCurrentJarGUI;
import com.Jessy1237.McVS.Management.TextMaker;
import com.Jessy1237.McVS.Management.TextWriter;
import com.Jessy1237.McVS.Management.Util;

public class Main {

	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome, "/AppData/roaming/.minecraft");
	public static File WinfileFolder = new File(Windir, "/mods");
	public static File Winfolder18 = new File(Windir, "/mods 1-8");
	public static File Winfolder17 = new File(Windir, "/mods 1-7");
	public static File Winfolder1 = new File(Windir, "/mods 1-0");
	public static File Winfolder11 = new File(Windir, "/mods 1-1");
	public static File Winfolder12 = new File(Windir, "/mods 1-2");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft");
	public static File fileFolder = new File(dir, "/mods");
	public static File folder18 = new File(dir, "/mods 1-8");
	public static File folder17 = new File(dir, "/mods 1-7");
	public static File folder1 = new File(dir, "/mods 1-0");
	public static File folder11 = new File(dir, "/mods 1-1");
	public static File folder12 = new File(dir, "/mods 1-2");
	public static File Lindir = new File(userHome, "/.minecraft");
	public static File LinfileFolder = new File(dir, "/mods");
	public static File Linfolder18 = new File(dir, "/mods 1-8");
	public static File Linfolder17 = new File(dir, "/mods 1-7");
	public static File Linfolder1 = new File(dir, "/mods 1-0");
	public static File Linfolder11 = new File(dir, "/mods 1-1");
	public static File Linfolder12 = new File(dir, "/mods 1-2");
	public static File Wintxt = new File(Windir, "/bin/mcversion.txt");
	public static File Mactxt = new File(dir, "/bin/mcversion.txt");
	public static File Lintxt = new File(dir, "/bin/mcversion.txt");
	public static int c = 0;
	public static String msg = "";
	public static InputCurrentJarGUI m = new InputCurrentJarGUI();
	public static boolean wait = false;
	
	public static void A() {
		boolean a = true;
		while (a == true) {
			String s = JOptionPane.showInputDialog(null, "Is your current minecraft jar a custom jar? (Yes/No)", "Minecraft Version Switcher: Input Current Jar", 1);
			if (s.equalsIgnoreCase("Yes")) {
				m.setVisible(true);
				a = false;
			} else if (s.equalsIgnoreCase("No")) {
				String text = JOptionPane.showInputDialog(null, "What is your current Minecraft Version? (E.g. 1.7.3 or 1.0)", "Minecraft Version Switcher: Input Current Jar", 1);
				if (text != null && !text.equals("")) {
					TextWriter t = new TextWriter();
					try {
						t.write(text);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					a = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Yes or No Answer... sigh!", "Minecraft Version Switcher: Input Current jar", 1);
			}
		}
	}

	public static void b() throws IOException {
		if(new File(Util.getDBFolder(), "/cJar.db").exists()){
			if(McVS.osName.contains("win")){
				new File(Util.getDBFolder(), "/cJar.db").delete();
				new File(Util.getDBFolder(), "/names.db").delete();
				Util.getDBFolder().delete();
				new File(Windir, "/bin/.mcversion.txt");
			}else if(McVS.osName.contains("mac")){
				new File(Util.getDBFolder(), "/cJar.db").delete();
				new File(Util.getDBFolder(), "/names.db").delete();
				Util.getDBFolder().delete();
				Mactxt.delete();
			}else if(McVS.osName.contains("linux")){
				new File(Util.getDBFolder(), "/cJar.db").delete();
				new File(Util.getDBFolder(), "/names.db").delete();
				Util.getDBFolder().delete();
				Lintxt.delete();
			}
		}
		if (!Wintxt.exists() && McVS.osName.contains("win")) {
			Wintxt.createNewFile();
			JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
			TextMaker.txt();
			McVS.mcver();
		}
		if (!Mactxt.exists() && McVS.osName.contains("mac")) {
			Mactxt.createNewFile();
			JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
			TextMaker.txt();
			McVS.mcver();
		}
		if (!Lintxt.exists() && McVS.osName.contains("linux")) {
			Lintxt.createNewFile();
			JOptionPane.showMessageDialog(null, "Text File Created, Re-open Program!", "Minecraft Version Switcher", 1);
			TextMaker.txt();
			McVS.mcver();
		}
		
		McVS.mcver();
		McVS mcvs = new McVS();
		if (McVS.mcver.getName() == "") {
			String s = JOptionPane.showInputDialog(null, "Is your current minecraft jar a custom jar? (Yes/No)", "Minecraft Version Switcher: Input Current Jar", 1);
			if (s.equalsIgnoreCase("Yes")) {
				m.setVisible(true);
				wait = true;
			} else if (s.equalsIgnoreCase("No")) {
				String text = JOptionPane.showInputDialog(null, "What is your current Minecraft Version? (E.g. 1.7.3 or 1.0)", "Minecraft Version Switcher: Input Current Jar", 1);
				if (text != null && !text.equals("")) {
					TextWriter t = new TextWriter();
					try {
						t.write(text);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Yes or No Answer... sigh!", "Minecraft Version Switcher: Input Current jar", 1);
				A();
			}
		} else {
			InputCurrentJarGUI.a();
		}
		while(wait == true){
			
		}
		McVS.mcver();
		if (McVS.osName.contains("win")) {
			if (!McVS.mcver.getName().equals("1.8") && !(Winfolder18.exists())) {
				Winfolder18.mkdir();
				msg = msg + "1.8";
				c++;
			}
			if (!McVS.mcver.getName().equals("1.7") && !(Winfolder17.exists())) {
				Winfolder17.mkdir();
				if (c > 0) {
					msg = msg + ", 1.7";
				} else {
					msg = msg + "1.7";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.0") && !(Winfolder1.exists())) {
				Winfolder1.mkdir();
				if (c > 0) {
					msg = msg + ", 1.0";
				} else {
					msg = msg + "1.0";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.1") && !(Winfolder11.exists())) {
				Winfolder11.mkdir();
				if (c > 0) {
					msg = msg + ", 1.1";
				} else {
					msg = msg + "1.1";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.2") && !(Winfolder12.exists())) {
				Winfolder12.mkdir();
				if (c > 0) {
					msg = msg + ", 1.2";
				} else {
					msg = msg + "1.2";
				}
				c++;
			}
			if (c > 0) {
				JOptionPane.showMessageDialog(null, "New mod folder/s '" + msg + "', was/were created at minecraft directory, The current mod folder is for the " + McVS.mcver + " jar.", "Minecraft Version Switcher", 1);
			}
		} else if (McVS.osName.contains("mac")) {
			if (!McVS.mcver.getName().equals("1.8") && !(folder18.exists())) {
				folder18.mkdir();
				msg = msg + "1.8";
				c++;
			}
			if (!McVS.mcver.getName().equals("1.7") && !(folder17.exists())) {
				folder17.mkdir();
				if (c > 0) {
					msg = msg + ", 1.7";
				} else {
					msg = msg + "1.7";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.0") && !(folder1.exists())) {
				folder1.mkdir();
				if (c > 0) {
					msg = msg + ", 1.0";
				} else {
					msg = msg + "1.0";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.1") && !(folder11.exists())) {
				folder11.mkdir();
				if (c > 0) {
					msg = msg + ", 1.1";
				} else {
					msg = msg + "1.1";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.2") && !(folder12.exists())) {
				folder12.mkdir();
				if (c > 0) {
					msg = msg + ", 1.2";
				} else {
					msg = msg + "1.2";
				}
				c++;
			}
			if (c > 0) {
				JOptionPane.showMessageDialog(null, "New mod folder/s '" + msg + "', was/were created at minecraft directory, The current mod folder is for the " + McVS.mcver + " jar.", "Minecraft Version Switcher", 1);
			}
		} else if (McVS.osName.contains("linux")) {
			if (!McVS.mcver.getName().equals("1.8") && !(Linfolder18.exists())) {
				Linfolder18.mkdir();
				msg = msg + "1.8";
				c++;
			}
			if (!McVS.mcver.getName().equals("1.7") && !(Linfolder17.exists())) {
				Linfolder17.mkdir();
				if (c > 0) {
					msg = msg + ", 1.7";
				} else {
					msg = msg + "1.7";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.0") && !(Linfolder1.exists())) {
				Linfolder1.mkdir();
				if (c > 0) {
					msg = msg + ", 1.0";
				} else {
					msg = msg + "1.0";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.1") && !(Linfolder11.exists())) {
				Linfolder11.mkdir();
				if (c > 0) {
					msg = msg + ", 1.1";
				} else {
					msg = msg + "1.1";
				}
				c++;
			}
			if (!McVS.mcver.getName().equals("1.2") && !(Linfolder12.exists())) {
				Linfolder12.mkdir();
				if (c > 0) {
					msg = msg + ", 1.2";
				} else {
					msg = msg + "1.2";
				}
				c++;
			}
			if (c > 0) {
				JOptionPane.showMessageDialog(null, "New mod folder/s '" + msg + "', was/were created at minecraft directory, The current mod folder is for the " + McVS.mcver + " jar.", "Minecraft Version Switcher", 1);
			}
		}
		mcvs.setVisible(true);
		mcvs.a.setText("Current Selected Version: " + McVS.mcver.getName());
	}

	public static void main(String[] args) throws Exception {
		b();
	}
}
