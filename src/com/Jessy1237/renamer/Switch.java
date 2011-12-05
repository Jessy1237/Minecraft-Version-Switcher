package com.Jessy1237.renamer;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Switch {
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft/bin");
	public static File Winfile18 = new File(Windir, "/1.8.jar");
	public static File Winfile17 = new File(Windir, "/1.7.jar");
	public static File Winfile1 = new File(Windir, "/1.0.jar");
	public static File WinfileJar = new File(Windir, "/minecraft.jar");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft/bin");
	public static File file18 = new File(dir, "/1.8.jar"); 
	public static File file17 = new File(dir, "/1.7.jar");
	public static File file1 = new File(dir, "/1.0.jar");
	public static File fileJar = new File(dir, "/minecraft.jar");
    static TextWriter Mac;
	static TextWriter Win;
	
	public Switch() {
		Win = new TextWriter();
		Mac = new TextWriter();
	}

	public void Switchw(String ver, File jar) throws IOException{
		if(Opener.mcver.equals("1.8") && !(Opener.Jar.equals("1.8"))){
			WinfileJar.renameTo(Winfile18);
		}
		if(Opener.mcver.equals("1.0") && !(Opener.Jar.equals("1.0"))){
			WinfileJar.renameTo(Winfile1);
		}
		if(Opener.mcver.equals("1.7") && !(Opener.Jar.equals("1.7"))){
			WinfileJar.renameTo(Winfile17);
		}
		if(!jar.exists()){
			if(Opener.mcver.equals("1.8") && Opener.Jar.equals("1.8")){
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			}else{
				if(Opener.mcver.equals("1.7") && Opener.Jar.equals("1.7")){
					JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
					ErrorWriter.JAS();
				}else{
					if(Opener.mcver.equals("1.0") && Opener.Jar.equals("1.0")){
						JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
						ErrorWriter.JAS();
					}else{
						JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
						ErrorWriter.Miss();
						if (Opener.mcver.equals("1.8")) {
							Winfile18.renameTo(WinfileJar);
							Win.Wintxt18();
						}
						if(Opener.mcver.equals("1.0")){
							Winfile1.renameTo(WinfileJar);
							Win.Wintxt1();
						}
						if(Opener.mcver.equals("1.7")){
							Winfile17.renameTo(WinfileJar);
							Win.Wintxt17();
						}
					}
				}
			}
		}else{
			boolean success = jar.renameTo(WinfileJar);
			if(!success){
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				if (Opener.mcver.equals("1.8")) {
					Winfile18.renameTo(WinfileJar);
					Win.Wintxt18();
				}
				if(Opener.mcver.equals("1.0")){
					Winfile1.renameTo(WinfileJar);
					Win.Wintxt1();
				}
				if(Opener.mcver.equals("1.7")){
					Winfile17.renameTo(WinfileJar);
				}
			}else{
				if(Opener.Jar.equals("1.7")){
					Win.Wintxt17();
				}
				if(Opener.Jar.equals("1.8")){
					Win.Wintxt18();
				}
				if(Opener.Jar.equals("1.0")){
					Win.Wintxt1();
				}				
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}
	
	public void Switchm(String ver, File jar) throws IOException{
		if(Opener.mcver.equals("1.8") && !(Opener.Jar.equals("1.8"))){
			fileJar.renameTo(file18);
		}
		if(Opener.mcver.equals("1.0") && !(Opener.Jar.equals("1.0"))){
			fileJar.renameTo(file1);
		}
		if(Opener.mcver.equals("1.7") && !(Opener.Jar.equals("1.7"))){
			fileJar.renameTo(file17);
		}
		if(!jar.exists()){
			if(Opener.mcver.equals("1.8") && Opener.Jar.equals("1.8")){
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			}else{
				if(Opener.mcver.equals("1.7") && Opener.Jar.equals("1.7")){
					JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
					ErrorWriter.JAS();
				}else{
					if(Opener.mcver.equals("1.0") && Opener.Jar.equals("1.0")){
						JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
						ErrorWriter.JAS();
					}else{
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
						if(Opener.mcver.equals("1.7")){
							file17.renameTo(fileJar);
							Mac.Mactxt17();
						}
					}
				}
			}
		}else{
			boolean success = jar.renameTo(fileJar);
			if(!success){
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
				if(Opener.mcver.equals("1.7")){
					file17.renameTo(fileJar);
				}
			}else{
				if(Opener.Jar.equals("1.7")){
					Mac.Wintxt17();
				}
				if(Opener.Jar.equals("1.8")){
					Win.Wintxt18();
				}
				if(Opener.Jar.equals("1.0")){
					Win.Wintxt1();
				}				
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}
}