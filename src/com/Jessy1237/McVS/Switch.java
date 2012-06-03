package com.Jessy1237.McVS;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.Jessy1237.McVS.Management.ErrorWriter;
import com.Jessy1237.McVS.Management.TextWriter;
import com.Jessy1237.McVS.Management.Util;

public class Switch {
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome, "/AppData/roaming/.minecraft");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft");
	static TextWriter T;

	public Switch() {
		T = new TextWriter();
	}

	public void switchJar(Jar jar) throws IOException {
		if (!McVS.mcver.equals(jar)) {
			Util.getFile("minecraft").renameTo(McVS.mcver.getJar());
		}
		if (!jar.getJar().exists()) {
			if (McVS.mcver.equals(McVS.Jar)) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			} else {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Miss();
				jar.getJar().renameTo(Util.getFile("minecraft"));
			}
		} else {
			boolean success = jar.getJar().renameTo(Util.getFile("minecraft"));
			if (!success) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				jar.getJar().renameTo(Util.getFile("minecraft"));
				Util.getFile("minecraft").renameTo(jar.getJar());
			} else {
				Util.getFolder("mods").renameTo(Util.getFolder(McVS.mcver.getName()));
				boolean success1 = Util.getFolder(jar.getName()).renameTo(Util.getFolder("mods"));
				if (!success1) {
					JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
					if (!Util.getFolder(jar.getName()).exists()) {
						ErrorWriter.FMiss(Util.getFolder(jar.getName()));
					} else {
						ErrorWriter.FUn();
					}
					Util.getFile("minecraft").renameTo(jar.getJar());
					McVS.mcver.getJar().renameTo(Util.getFile("minecraft"));
					Util.getFolder("mods").renameTo(Util.getFolder(jar.getName()));
				} else {
					T.write(jar.getName());
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}
}