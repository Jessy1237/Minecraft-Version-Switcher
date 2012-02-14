package com.Jessy1237.McVS;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Switch {
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft");
    static TextWriter T;
	
	public Switch() {
		T = new TextWriter();
	}
	
	public void switchJar(String ver) throws IOException{
		if(!McVS.mcver.equals(ver)){
			getFile("minecraft").renameTo(getFile(McVS.mcver));
		}
		if(!getFile(ver).exists()){
			if(McVS.mcver.equals("1.8") && McVS.Jar.equals("1.8")){
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			}else{
				if(McVS.mcver.equals("1.7") && McVS.Jar.equals("1.7")){
					JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
					ErrorWriter.JAS();
				}else{
					if(McVS.mcver.equals("1.0") && McVS.Jar.equals("1.0")){
						JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
						ErrorWriter.JAS();
					}else{
						if(McVS.mcver.equals("1.1") && McVS.Jar.equals("1.1")){
							JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
							ErrorWriter.JAS();
						}else{
							JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
							ErrorWriter.Miss();
							getFile(ver).renameTo(getFile("minecraft"));
						}
					}
				}
			}	
		}else{
			boolean success = getFile(ver).renameTo(getFile("minecraft"));
			if(!success){
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				getFile(ver).renameTo(getFile("minecraft"));
				getFile("minecraft").renameTo(getFile(ver));
			}else{
				getFolder("mods").renameTo(getFolder(McVS.mcver));
				boolean success1 = getFolder(ver).renameTo(getFolder("mods"));
				if(!success1){
					JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
					if(!getFolder(ver).exists()){
						ErrorWriter.FMiss(getFolder(ver));
					}else{
						ErrorWriter.FUn();
					}
					getFile("minecraft").renameTo(getFile(ver));
					getFile(McVS.mcver).renameTo(getFile("minecraft"));
					getFolder("mods").renameTo(getFolder(ver));
				}else{
					T.write(ver);
				}			
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}
	
	public static File getcFile(String jar){
		File file = null;
		if(McVS.osName.contains("win")){
			file = new File(Windir, "/bin/" + jar+ ".jar");
		}
		if(McVS.osName.contains("mac")){
			file = new File(dir, "/bin/" + jar + ".jar");
		}
		return file;
	}
	
	public static File getFile(String jar){
		File file = null;
		if(McVS.osName.contains("win")){
			if(jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("minecraft")){
				file = new File(Windir, "/bin/" + jar + ".jar");
			}else{
				file = getcFile(jar);
			}
		}
		if(McVS.osName.contains("mac")){
			if(jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("minecraft")){
				file = new File(dir, "/bin/" + jar + ".jar");
			}else{
				file = getcFile(jar);
			}
		}
		return file;
	}
	
	public static File getcFolder(String jar){
		File file = null;
		if(McVS.osName.contains("win")){
			file = new File(Windir, "/mods " + jar);
		}
		if(McVS.osName.contains("mac")){
			file = new File(dir, "/mods " + jar);
		}
		return file;
	}
	
	public static File getFolder(String jar){
		File file = null;
		String s = jar;
		if(McVS.osName.contains("win")){
			if(jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1")){
				s = s.replace(".", "-");
				file = new File(Windir, "/mods " + s);
			}else{
				if(jar.equals("mods")){
					s = s.replace(".", "-");
					file = new File(Windir, "/mods");
				}else{
					file = getcFolder(jar);
				}
			}
		}
		if(McVS.osName.contains("mac")){
			if(jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1")){
				s = s.replace(".", "-");
				file = new File(dir, "/mods " + s);
			}else{
				if(jar.equals("mods")){
					s = s.replace(".", "-");
					file = new File(dir, "/mods");
				}else{
					file = getcFolder(jar);
				}
			}
		}
		return file;
	}
}