package com.Jessy1237.McVS.GUI;

import javax.swing.*;

import com.Jessy1237.McVS.McVS;
import com.Jessy1237.McVS.Management.Download;
import com.Jessy1237.McVS.Management.Login;
import com.Jessy1237.McVS.Management.TextWriter;
import com.Jessy1237.McVS.Management.Update;
import com.Jessy1237.McVS.Management.Util;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class dLoadJars extends JFrame {

	public JButton DL1;
	public JButton DL18;
	public JButton DL17;
	public JButton DL11;
	public JButton DL12;
	public JButton Back;
	public JLabel mcver;

	public static String v = "";
	public static TextWriter T;
	public static Update u;

	public dLoadJars() {
		T = new TextWriter();
		u = new Update();

		this.setTitle("Minecraft Version Switcher: Download Minecraft Jars");
		this.setSize(new Dimension(480, 250));
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
		
		this.DL12 = new JButton();
		this.DL12.setText("Download Minecraft 1.2");
		this.DL12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = "1.2";
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
		
		DL12.setBounds(130, 101, 220, 30);

		Back.setBounds(202, 148, 75, 30);

		mcver = new JLabel();
		mcver.setText("Current Selected Jar: " + McVS.mcver.getName());
		mcver.setBounds(10, 195, 300, 20);
		mcver.setFont(new Font("Arial", Font.PLAIN, 14));
		
		add(DL18);
		add(DL17);
		add(DL1);
		add(DL11);
		add(DL12);
		add(Back);
		add(mcver);
	}

	public static void DL12_actionPerformed() throws IOException {
		Util.getFile("minecraft").renameTo(McVS.mcver.getJar());
		Util.getFolder("mods").renameTo(Util.getFolder(McVS.mcver.getName()));
		if (Util.getFile("1.2").exists()) {
			Util.getFile("1.2").renameTo(Util.getFile("minecraft"));
		}
		Util.getFolder("1.2").renameTo(Util.getFolder("mods"));
		T.write("1.2");
		Download p = new Download();
		p.setVisible(true);
	}
	
	public static void DL11_actionPerformed() throws IOException {
		Util.getFile("minecraft").renameTo(McVS.mcver.getJar());
		Util.getFolder("mods").renameTo(Util.getFolder(McVS.mcver.getName()));
		if (Util.getFile("1.1").exists()) {
			Util.getFile("1.1").renameTo(Util.getFile("minecraft"));
		}
		Util.getFolder("1.1").renameTo(Util.getFolder("mods"));
		T.write("1.1");
		Download p = new Download();
		p.setVisible(true);
	}

	public static void DL1_actionPerformed() throws IOException {
		Util.getFile("minecraft").renameTo(McVS.mcver.getJar());
		Util.getFolder("mods").renameTo(Util.getFolder(McVS.mcver.getName()));
		if (Util.getFile("1.0").exists()) {
			Util.getFile("1.0").renameTo(Util.getFile("minecraft"));
		}
		Util.getFolder("1.0").renameTo(Util.getFolder("mods"));
		T.write("1.0");
		Download p = new Download();
		p.setVisible(true);
	}

	public static void DL17_actionPerformed() throws IOException {
		Util.getFile("minecraft").renameTo(McVS.mcver.getJar());
		Util.getFolder("mods").renameTo(Util.getFolder(McVS.mcver.getName()));
		if (Util.getFile("1.7").exists()) {
			Util.getFile("1.7").renameTo(Util.getFile("minecraft"));
		}
		Util.getFolder("1.7").renameTo(Util.getFolder("mods"));
		T.write("1.7");
		Download p = new Download();
		p.setVisible(true);
	}

	public static void DL18_actionPerformed() throws IOException {
		Util.getFile("minecraft").renameTo(McVS.mcver.getJar());
		Util.getFolder("mods").renameTo(Util.getFolder(McVS.mcver.getName()));
		if (Util.getFile("1.8").exists()) {
			Util.getFile("1.8").renameTo(Util.getFile("minecraft"));
		}
		Util.getFolder("1.8").renameTo(Util.getFolder("mods"));
		T.write("1.8");
		Download p = new Download();
		p.setVisible(true);
	}

}
