package com.Jessy1237.renamer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Opener extends JFrame {
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
	public static File Wintxt = new File(Windir, "/.mcversion.txt");
	public static File Mactxt = new File(dir, "/mcversion.txt");
	public static double vernum = 3.41;
	public static String osName = System.getProperty("os.name").toLowerCase();
	public JButton Play18;
	public static String Jar = "";
	public JButton Play17;
	public JButton dLoad;
	public JButton Updateb;
	public JButton Play1;
	private JLabel Version1;
	private static JLabel mcverlabel;
	static Switch S;
	static TextWriter Wr;
	static TextMaker Ma;
	static Update U;
	static Properties prop = new Properties();
	public static String mcver;

	public static void mcver() throws IOException {
		if (osName.contains("win")) {
			if (Wintxt.exists()) {
				FileInputStream in = new FileInputStream(Wintxt);
				prop.load(in);
				mcver = prop.getProperty("jar");
				in.close();
			}
		} else {
			if (Mactxt.exists()) {
				FileInputStream in = new FileInputStream(Mactxt);
				prop.load(in);
				mcver = prop.getProperty("jar");
				in.close();
			}
		}
	}

	public Opener() {
		S = new Switch();
		Wr = new TextWriter();
		Ma = new TextMaker();
		this.setTitle("Minecraft Version Switcher");
		this.setSize(new Dimension(480, 200));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Updateb = new JButton();
		this.Updateb.setText("Check for updates");
		this.Updateb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Update.download();
			}
		});
		this.Play1 = new JButton();
		this.Play1.setText("Play Minecraft 1.0");
		this.Play1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Play1_ActionPerformed();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		this.dLoad = new JButton();
		this.dLoad.setText("Download Minecraft Jars");
		this.dLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dLoad_ActionPerformed();
					setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		this.Play18 = new JButton();
		this.Play18.setText("Play Minecraft Beta 1.8");
		this.Play18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Play18_ActionPerformed();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		this.Play17 = new JButton();
		this.Play17.setText("Play Minecraft Beta 1.7");
		this.Play17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Play17_ActionPerformed();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mcverlabel = new JLabel();
		mcverlabel.setText("Current Selected Jar: " + mcver);
		Version1 = new JLabel();
		Version1.setText("Program Version: " + vernum);

		Play18.setBounds(20, 15, 180, 30);
		Play17.setBounds(275, 15, 180, 30);
		dLoad.setBounds(20, 58, 180, 30);
		Play1.setBounds(275, 58, 180, 30);
		Updateb.setBounds(158, 105, 150, 30);
		mcverlabel.setSize(180, 20);
		mcverlabel.setLocation(275, 145);
		mcverlabel.setFont(new Font("Arial", Font.PLAIN, 14));
		Version1.setSize(150, 20);
		Version1.setLocation(40, 145);
		Version1.setFont(new Font("Arial", Font.PLAIN, 14));

		add(Play18);
		add(Play17);
		add(dLoad);
		add(Play1);
		add(Updateb);
		add(Version1);
		add(mcverlabel);
	}

	public static void Play1_ActionPerformed() throws IOException {
		Jar = "1.0";
		if (osName.contains("win")) {
			S.Switchw("1.0", Winfile1);
		}
		if (osName.contains("mac")) {
			S.Switchm("1.0", file1);
		}
		mcver();
		mcverlabel.setText("Current Selected Jar: " + mcver);
	}

	private static void Play17_ActionPerformed() throws IOException {
		Jar = "1.7";
		if (osName.contains("win")) {
			S.Switchw("1.7", Winfile17);
		}
		if (osName.contains("mac")) {
			S.Switchm("1.7", file17);
		}
		mcver();
		mcverlabel.setText("Current Selected Jar: " + mcver);
	}

	private static void Play18_ActionPerformed() throws IOException {
		Jar = "1.8";
		if (osName.contains("win")) {
			S.Switchw("1.8", Winfile18);
		}
		if (osName.contains("mac")) {
			S.Switchm("1.8", file18);
		}
		mcver();
		mcverlabel.setText("Current Selected Jar: " + mcver);
	}

	public static void dLoad_ActionPerformed() throws IOException {
		dLoadJars d = new dLoadJars();
		d.setVisible(true);
	}
}