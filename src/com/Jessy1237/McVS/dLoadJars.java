package com.Jessy1237.McVS;

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
	public JButton DL11;
	public JButton Back;
	public JLabel mcver;
	public JLabel version;

	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft");
	public static File dir = new File(userHome,
			"/Library/Application Support/minecraft");
	public static File Winfile18 = new File(Windir, "/bin/1.8.jar");
	public static File Winfile17 = new File(Windir, "/bin/1.7.jar");
	public static File Winfile1 = new File(Windir, "/bin/1.0.jar");
	public static File Winfile11 = new File(Windir, "/bin/1.1.jar");
	public static File WinfileJar = new File(Windir, "/bin/minecraft.jar");
	public static File file18 = new File(dir, "/bin/1.8.jar");
	public static File file17 = new File(dir, "/bin/1.7.jar");
	public static File file1 = new File(dir, "/bin/1.0.jar");
	public static File file11 = new File(dir, "/bin/1.1.jar");
	public static File fileJar = new File(dir, "/bin/minecraft.jar");
	public static File WinfileFolder = new File(Windir, "/mods");
	public static File Winfolder18 = new File(Windir, "/mods 1-8");
	public static File Winfolder17 = new File(Windir, "/mods 1-7");
	public static File Winfolder1 = new File(Windir, "/mods 1-0");
	public static File Winfolder11 = new File(Windir, "/mods 1-1");
	public static File fileFolder = new File(dir, "/mods");
	public static File folder18 = new File(dir, "/mods 1-8");
	public static File folder17 = new File(dir, "/mods 1-7");
	public static File folder1 = new File(dir, "/mods 1-0");
	public static File folder11 = new File(dir, "/mods 1-1");
	public static String osName = System.getProperty("os.name").toLowerCase();

	public static String v = "";
	public static TextWriter T;
	public static Update u;

	public dLoadJars() {
		T = new TextWriter();
		u = new Update();

		this.setTitle("Minecraft Version Switcher: Download Minecraft Jars");
		this.setSize(new Dimension(480, 200));
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.DL11 = new JButton();
		this.DL11.setText("Download Minecraft 1.1");
		this.DL11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = "1.1";
				Download.c = 0;
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});
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
				McVS o = new McVS();
				o.setVisible(true);

			}
		});

		DL1.setBounds(10, 58, 220, 30);

		DL11.setBounds(245, 58, 220, 30);

		DL18.setBounds(10, 15, 220, 30);

		DL17.setBounds(245, 15, 220, 30);

		Back.setBounds(202, 105, 75, 30);

		mcver = new JLabel();
		mcver.setText("Current Selected Jar: " + McVS.mcver);
		mcver.setBounds(275, 145, 180, 20);
		mcver.setFont(new Font("Arial", Font.PLAIN, 14));

		version = new JLabel();
		version.setText("Program Version: " + McVS.vernum);
		version.setBounds(40, 145, 150, 20);
		version.setFont(new Font("Arial", Font.PLAIN, 14));

		add(DL18);
		add(DL17);
		add(DL1);
		add(DL11);
		add(Back);
		add(version);
		add(mcver);
	}

	public static void DL11_actionPerformed() throws IOException {
		Switch.getFile("minecraft").renameTo(Switch.getFile(McVS.mcver));
		Switch.getFolder("mods").renameTo(Switch.getFolder(McVS.mcver));
		if (Switch.getFile("1.1").exists()) {
			Switch.getFile("1.1").renameTo(Switch.getFile("minecraft"));
		}
		Switch.getFolder("1.1").renameTo(Switch.getFolder("mods"));
		T.write("1.1");
		Download p = new Download();
		p.setVisible(true);
	}

	public static void DL1_actionPerformed() throws IOException {
		Switch.getFile("minecraft").renameTo(Switch.getFile(McVS.mcver));
		Switch.getFolder("mods").renameTo(Switch.getFolder(McVS.mcver));
		if (Switch.getFile("1.0").exists()) {
			Switch.getFile("1.0").renameTo(Switch.getFile("minecraft"));
		}
		Switch.getFolder("1.0").renameTo(Switch.getFolder("mods"));
		T.write("1.0");
		Download p = new Download();
		p.setVisible(true);
	}

	public static void DL17_actionPerformed() throws IOException {
		Switch.getFile("minecraft").renameTo(Switch.getFile(McVS.mcver));
		Switch.getFolder("mods").renameTo(Switch.getFolder(McVS.mcver));
		if (Switch.getFile("1.7").exists()) {
			Switch.getFile("1.7").renameTo(Switch.getFile("minecraft"));
		}
		Switch.getFolder("1.7").renameTo(Switch.getFolder("mods"));
		T.write("1.7");
		Download p = new Download();
		p.setVisible(true);
	}

	public static void DL18_actionPerformed() throws IOException {
		Switch.getFile("minecraft").renameTo(Switch.getFile(McVS.mcver));
		Switch.getFolder("mods").renameTo(Switch.getFolder(McVS.mcver));
		if (Switch.getFile("1.8").exists()) {
			Switch.getFile("1.8").renameTo(Switch.getFile("minecraft"));
		}
		Switch.getFolder("1.8").renameTo(Switch.getFolder("mods"));
		T.write("1.8");
		Download p = new Download();
		p.setVisible(true);
	}

}
