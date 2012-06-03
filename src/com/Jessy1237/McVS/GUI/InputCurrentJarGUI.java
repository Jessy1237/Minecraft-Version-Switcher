package com.Jessy1237.McVS.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.Jessy1237.McVS.Jar;
import com.Jessy1237.McVS.Main;
import com.Jessy1237.McVS.McVS;
import com.Jessy1237.McVS.Management.TextWriter;
import com.Jessy1237.McVS.Management.Util;

@SuppressWarnings("serial")
public class InputCurrentJarGUI extends JFrame {

	public JButton bu;
	public JTextField name;
	public JTextArea desc;
	public JLabel Desc;
	public JLabel info;
	public JLabel Name;

	public static boolean adding = false;
	public static String osName = System.getProperty("os.name").toLowerCase();
	public static String userHome = System.getProperty("user.home");
	public static File Windir = new File(userHome, "/AppData/roaming/.minecraft/bin");
	public static File dir = new File(userHome, "/Library/Application Support/minecraft/bin");
	public static File Wintxt = new File(Windir, "/.mcversion.txt");
	public static File Mactxt = new File(dir, "/mcversion.txt");

	public static void a() {
		InputCurrentJarGUI i = new InputCurrentJarGUI();
		i.setVisible(false);
	}

	public InputCurrentJarGUI() {

		this.setTitle("Minecraft Version Switcher: Input Current Jar");

		if (adding)
			this.setTitle("Minecraft Version Switcher: Add Jar");
		this.setSize(new Dimension(480, 220));
		this.setLocation(MouseInfo.getPointerInfo().getLocation());
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.name = new JTextField();
		this.name.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (adding == true) {
					setVisible(false);
					String text;
					text = name.getText();
					try {
						Util.addJar(new Jar(text, Util.getcFile(text), desc.getText()));
					} catch (IOException e2) {
						e2.printStackTrace();
					}

					McVS newform = new McVS();
					newform.setVisible(true);
				} else {
					String text;
					text = name.getText();
					setVisible(false);
					try {
						Jar jar = new Jar(text, Util.getcFile(text), desc.getText());
						Util.jars.put(jar.getName(), jar);
						McVS.model.add(McVS.list.getModel().getSize(), "Play " + jar.getName());
						Util.write();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					TextWriter t = new TextWriter();
					try {
						t.write(text);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Main.wait = false;
				}
			}
		});

		this.bu = new JButton();
		this.bu.setText("Done");
		this.bu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adding == true) {
					String text;
					text = name.getText();
					setVisible(false);
					try {
						Util.addJar(new Jar(text, Util.getcFile(text), desc.getText()));
					} catch (IOException e2) {
						e2.printStackTrace();
					}

					McVS newform = new McVS();
					newform.setVisible(true);
				} else {
					String text;
					text = name.getText();
					setVisible(false);
					try {
						Jar jar = new Jar(text, Util.getcFile(text), desc.getText());
						Util.jars.put(jar.getName(), jar);
						McVS.model.add(McVS.list.getModel().getSize(), "Play " + jar.getName());
						Util.write();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					TextWriter t = new TextWriter();
					try {
						t.write(text);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Main.wait = false;
				}
			}
		});

		Name = new JLabel();
		Name.setText("Name/Version:");
		Name.setBounds(10, 40, 95, 20);
		Name.setFont(new Font("Arial", Font.PLAIN, 14));

		Desc = new JLabel();
		Desc.setText("Description:");
		Desc.setFont(new Font("Arial", Font.PLAIN, 14));
		Desc.setBounds(10, 65, 180, 20);

		desc = new JTextArea();
		desc.setLineWrap(true);
		desc.setFont(new Font("Arial", Font.PLAIN, 14));
		desc.setBounds(10, 90, 465, 60);

		info = new JLabel();
		info.setText("Enter the details for you current minecraft jar. Custom Jars are Allowed!");

		if (adding)
			info.setText("Enter the details of the jar!");

		info.setFont(new Font("Arial", Font.PLAIN, 14));
		info.setBounds(10, 10, 460, 20);

		name.setBounds(110, 40, 180, 25);

		bu.setBounds(185, 155, 70, 30);

		add(Name);
		add(Desc);
		add(name);
		add(desc);
		add(info);
		add(bu);
	}
}