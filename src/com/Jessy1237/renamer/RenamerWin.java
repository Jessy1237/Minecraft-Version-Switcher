package com.Jessy1237.renamer;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RenamerWin {
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft/bin");
	public static File Winfile18 = new File(Windir, "/1.8.jar");
	public static File Winfile17 = new File(Windir, "/1.7.jar");
	public static File Winfile1 = new File(Windir, "/1.0.jar");
	public static File WinfileJar = new File(Windir, "/minecraft.jar");
	static TextWriter Win;

	public RenamerWin() {
		Win = new TextWriter();
	}

	public void Win18() throws IOException {
		Opener.Jar = "1.8";
		if (Opener.mcver.equals("1.7")) {
			WinfileJar.renameTo(Winfile17);
		}
		if(Opener.mcver.equals("1.0")){
			WinfileJar.renameTo(Winfile1);
		}
		boolean exists = (Winfile18).exists();
		if (!exists) {
			if (Opener.mcver.equals("1.8")) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
				if (Opener.mcver.equals("1.7")) {
					Winfile17.renameTo(WinfileJar);
					Win.Wintxt17();
				}
				if(Opener.mcver.equals("1.0")){
					Winfile1.renameTo(WinfileJar);
					Win.Wintxt1();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Miss();
				if (Opener.mcver.equals("1.7")) {
					Winfile17.renameTo(WinfileJar);
					Win.Wintxt17();
				}
				if(Opener.mcver.equals("1.0")){
					Winfile1.renameTo(WinfileJar);
					Win.Wintxt1();
				}
			}
		} else {
			boolean success1 = Winfile18.renameTo(WinfileJar);
			if (!success1) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				if (Opener.mcver.equals("1.7")) {
					Winfile18.renameTo(WinfileJar);
					Win.Wintxt17();
				}
				if(Opener.mcver.equals("1.0")){
					Winfile1.renameTo(WinfileJar);
					Win.Wintxt1();
				}
			} else {
				Win.Wintxt18();
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}

	public void Win17() throws IOException {
		Opener.Jar = "1.7";
		if (Opener.mcver.equals("1.8")) {
			WinfileJar.renameTo(Winfile18);
		}
		if(Opener.mcver.equals("1.0")){
			WinfileJar.renameTo(Winfile1);
		}
		boolean exists = (Winfile17).exists();
		if (!exists) {
			if (Opener.mcver.equals("1.7")) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			} else {
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
			}
		} else {
			boolean success1 = Winfile17.renameTo(WinfileJar);
			if (!success1) {
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
			} else {
				Win.Wintxt17();
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}

	public void Win1() throws IOException {
		Opener.Jar = "1.0";
		if(Opener.mcver.equals("1.8")){
			WinfileJar.renameTo(Winfile18);
		}
		if(Opener.mcver.equals("1.7")){
			WinfileJar.renameTo(Winfile17);
		}
		boolean exists = (Winfile1).exists();
		if (!exists) {
			if (Opener.mcver.equals("1.0")) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.JAS();
			} else {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Miss();
				if (Opener.mcver.equals("1.8")) {
					Winfile18.renameTo(WinfileJar);
					Win.Wintxt18();
				}
				if (Opener.mcver.equals("1.7")) {
					Winfile17.renameTo(WinfileJar);
					Win.Wintxt17();
				}
			}
		} else {

			boolean success1 = Winfile1.renameTo(WinfileJar);
			if (!success1) {
				JOptionPane.showMessageDialog(null, "Reverting to Previous successful settings, Check the Error Log on your desktop.", "Minecraft Version Switcher", 1);
				ErrorWriter.Un();
				if (Opener.mcver.equals("1.8")) {
					Winfile18.renameTo(WinfileJar);
					Win.Wintxt18();
				}
				if (Opener.mcver.equals("1.7")) {
					Winfile17.renameTo(WinfileJar);
					Win.Wintxt17();
				}
			} else {
				Win.Wintxt1();
			}
		}
		JOptionPane.showMessageDialog(null, "Done", "Minecraft Version Switcher", 1);
	}
}
