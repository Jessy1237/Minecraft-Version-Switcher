package com.Jessy1237.renamer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class dLoadJars extends JFrame {

	public JButton DL1;
	public JButton DL18;
	public JButton DL17;
	public JButton Back;
	public JLabel mcver;
	public JLabel version;

	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft/bin");
	public static File Winfile18 = new File(Windir, "/1.8.jar");
	public static File Winfile17 = new File(Windir, "/1.7.jar");
	public static File Winfile1 = new File(Windir, "/1.0.jar");
	public static File WinfileJar = new File(Windir, "/minecraft.jar");
	public static File dir = new File(userHome,
			"/Library/Application Support/minecraft/bin");
	public static File file18 = new File(dir, "/1.8.jar");
	public static File file17 = new File(dir, "/1.7.jar");
	public static File file1 = new File(dir, "/1.0.jar");
	public static File fileJar = new File(dir, "/minecraft.jar");
	public static String osName = System.getProperty("os.name").toLowerCase();

	public static String v = "";
	public static TextWriter T;

	public dLoadJars() {
		T = new TextWriter();

		this.setTitle("Minecraft Version Switcher: Download Minecraft Jars");
		this.setSize(new Dimension(480, 200));
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.DL1 = new JButton();
		this.DL1.setText("Download Minecraft 1.0");
		this.DL1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = "1.0";
				Download.c = 0;
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});

		this.DL18 = new JButton();
		this.DL18.setText("Download Minecraft Beta 1.8");
		this.DL18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = "1.8";
				Download.c = 0;
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});

		this.DL17 = new JButton();
		this.DL17.setText("Download Minecraft Beta 1.7");
		this.DL17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = "1.7";
				Download.c = 0;
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});

		this.Back = new JButton();
		this.Back.setText("Back");
		this.Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Opener o = new Opener();
				o.setVisible(true);

			}
		});

		DL1.setBounds(130, 58, 220, 30);

		DL18.setBounds(10, 15, 220, 30);

		DL17.setBounds(245, 15, 220, 30);

		Back.setBounds(202, 105, 75, 30);

		mcver = new JLabel();
		mcver.setText("Current Selected Jar: " + Opener.mcver);
		mcver.setBounds(275, 145, 180, 20);
		mcver.setFont(new Font("Arial", Font.PLAIN, 14));

		version = new JLabel();
		version.setText("Program Version: " + Opener.vernum);
		version.setBounds(40, 145, 150, 20);
		version.setFont(new Font("Arial", Font.PLAIN, 14));

		add(DL18);
		add(DL17);
		add(DL1);
		add(Back);
		add(version);
		add(mcver);
	}

	public static void DL1_actionPerformed() throws IOException {
		if (osName.contains("win")) {
			if (Opener.mcver.equals("1.8")) {
				WinfileJar.renameTo(Winfile18);
			}
			if (Opener.mcver.equals("1.7")) {
				WinfileJar.renameTo(Winfile17);
			}
			if (Winfile1.exists()) {
				Winfile1.renameTo(WinfileJar);
			}
			T.Wintxt1();
			Download p = new Download();
			p.setVisible(true);
		}
		if (osName.contains("mac")) {
			if (Opener.mcver.equals("1.8")) {
				fileJar.renameTo(file18);
			}
			if (Opener.mcver.equals("1.7")) {
				fileJar.renameTo(file17);
			}
			if (file1.exists()) {
				file1.renameTo(fileJar);
			}
			T.Mactxt1();
			Download p = new Download();
			p.setVisible(true);
		}
	}

	public static void DL17_actionPerformed() throws IOException {
		if (osName.contains("win")) {
			if (Opener.mcver.equals("1.8")) {
				WinfileJar.renameTo(Winfile18);
			}
			if (Opener.mcver.equals("1.0")) {
				WinfileJar.renameTo(Winfile1);
			}
			if (Winfile17.exists()) {
				Winfile17.renameTo(WinfileJar);
			}
			T.Wintxt17();
			Download p = new Download();
			p.setVisible(true);
		}
		if (osName.contains("mac")) {
			if (Opener.mcver.equals("1.8")) {
				fileJar.renameTo(file18);
			}
			if (Opener.mcver.equals("1.0")) {
				fileJar.renameTo(file1);
			}
			if (file17.exists()) {
				file17.renameTo(fileJar);
			}
			T.Mactxt17();
			Download p = new Download();
			p.setVisible(true);
		}
	}

	public static void DL18_actionPerformed() throws IOException {
		if (osName.contains("win")) {
			if (Opener.mcver.equals("1.7")) {
				WinfileJar.renameTo(file17);
			}
			if (Opener.mcver.equals("1.0")) {
				WinfileJar.renameTo(Winfile1);
			}
			if (Winfile18.exists()) {
				Winfile18.renameTo(WinfileJar);
			}
			T.Wintxt18();
			Download p = new Download();
			p.setVisible(true);
		}
		if (osName.contains("mac")) {
			if (Opener.mcver.equals("1.7")) {
				fileJar.renameTo(file17);
			}
			if (Opener.mcver.equals("1.0")) {
				fileJar.renameTo(file1);
			}
			if (file18.exists()) {
				file18.renameTo(WinfileJar);
			}
			T.Mactxt18();
			Download p = new Download();
			p.setVisible(true);
		}
	}
}
