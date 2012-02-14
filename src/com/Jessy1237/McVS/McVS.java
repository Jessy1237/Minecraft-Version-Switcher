package com.Jessy1237.McVS;

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
public class McVS extends JFrame {
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome,
			"/AppData/roaming/.minecraft");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft");
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
	public static File Wintxt = new File(Windir, "/bin/.mcversion.txt");
	public static File Mactxt = new File(dir, "/bin/mcversion.txt");
	public static double vernum = 5.0;
	public static String osName = System.getProperty("os.name").toLowerCase();
	public JButton Play18;
	public static String Jar = "";
	public JButton Play17;
	public JButton Play11;
	public JButton Email;
	public JButton dLoad;
	public JButton Updateb;
	public JButton Play1;
	public JButton cJar;
	static JLabel Version1;
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

	public McVS() {
		S = new Switch();
		Wr = new TextWriter();
		Ma = new TextMaker();
		this.setTitle("Minecraft Version Switcher By Jessy1237");
		this.setSize(new Dimension(480, 250));
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
		this.Play11 = new JButton();
		this.Play11.setText("Play Minecraft 1.1");
		this.Play11.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				try{
					Play11_ActionPerformed();
				}catch(IOException e1){
					e1.printStackTrace();
				}
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
		
		this.Email = new JButton();
		this.Email.setText("Talk to Dev");
		this.Email.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Emailer em = new Emailer();
				em.setVisible(true);
				setVisible(false);
			}
		});
		
		this.cJar = new JButton();
		this.cJar.setText("Play Custom Minecraft Jar");
		this.cJar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CustomJars cj = new CustomJars();
				cj.setVisible(true);
				setVisible(false);
			}
		});
		
		mcverlabel = new JLabel();
		mcverlabel.setText("Current Selected Version: " + mcver);
		Version1 = new JLabel();
		Version1.setText("Program Version:");
		Thread t = new Thread(new Update());
		t.start();

		Play18.setBounds(20, 15, 180, 30);
		Play17.setBounds(275, 15, 180, 30);
		Play11.setBounds(275, 58, 180, 30);
		dLoad.setBounds(20, 101, 180, 30);
		cJar.setBounds(265, 101, 200, 30);
		Play1.setBounds(20, 58, 180, 30);
		Updateb.setBounds(35, 144, 150, 30);
		Email.setBounds(290, 144, 150, 30);
		
		mcverlabel.setSize(240, 20);
		mcverlabel.setLocation(230, 188);
		mcverlabel.setFont(new Font("Arial", Font.PLAIN, 14));
		Version1.setSize(260, 20);
		Version1.setLocation(10, 188);
		Version1.setFont(new Font("Arial", Font.PLAIN, 14));

		add(Play18);
		add(Play17);
		add(dLoad);
		add(cJar);
		add(Play1);
		add(Play11);
		add(Updateb);
		add(Email);
		add(Version1);
		add(mcverlabel);
		try{
			mcver();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void Play1_ActionPerformed() throws IOException {
		Jar = "1.0";
		S.switchJar("1.0");
		mcver();
		mcverlabel.setText("Current Selected Jar: " + mcver);
	}

	private static void Play17_ActionPerformed() throws IOException {
		Jar = "1.7";
		S.switchJar("1.7");
		mcver();
		mcverlabel.setText("Current Selected Jar: " + mcver);
	}

	private static void Play18_ActionPerformed() throws IOException {
		Jar = "1.8";
		S.switchJar("1.8");
		mcver();
		mcverlabel.setText("Current Selected Jar: " + mcver);
	}
	
	private static void Play11_ActionPerformed() throws IOException{
		Jar = "1.1";
		S.switchJar("1.1");
		mcver();
		mcverlabel.setText("Current Selected Jar: " + mcver);
	}

	public static void dLoad_ActionPerformed() throws IOException {
		dLoadJars d = new dLoadJars();
		d.setVisible(true);
	}
}