package com.Jessy1237.McVS.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.Jessy1237.McVS.Jar;
import com.Jessy1237.McVS.McVS;

@SuppressWarnings("serial")
public class InfoGUI extends JFrame{

	public JTextArea desc;
	public JTextField name;
	public JTextField path;
	public JLabel Desc;
	public JLabel Name;
	public JLabel Path;
	public JButton back;
	
	public InfoGUI(Jar jar) {
		this.setTitle("Minecraft Version Switcher: Jar Information");
		this.setSize(new Dimension(480, 240));
		this.setLocation(MouseInfo.getPointerInfo().getLocation());
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Name = new JLabel();
		Name.setText("Name/Version:");
		Name.setBounds(10, 10, 95, 20);
		Name.setFont(new Font("Arial", Font.PLAIN, 14));

		Desc = new JLabel();
		Desc.setText("Description:");
		Desc.setFont(new Font("Arial", Font.PLAIN, 14));
		Desc.setBounds(10, 60, 180, 20);

		desc = new JTextArea();
		desc.setText(jar.getDesc());
		desc.setEditable(false);
		desc.setLineWrap(true);
		desc.setFont(new Font("Arial", Font.PLAIN, 14));
		desc.setBounds(10, 85, 465, 90);
		
		name = new JTextField();
		name.setText(jar.getName());
		name.setEditable(false);
		name.setFont(new Font("Arial", Font.PLAIN, 14));
		name.setBounds(110, 10, 180, 25);
		
		path = new JTextField();
		path.setText(jar.getJar().getAbsolutePath());
		path.setEditable(false);
		path.setFont(new Font("Arial", Font.PLAIN, 14));
		path.setBounds(110, 35, 180, 25);
		
		Path = new JLabel();
		Path.setText("Path:");
		Path.setBounds(10, 35, 95, 20);
		Path.setFont(new Font("Arial", Font.PLAIN, 14));
		
		back = new JButton();
		back.setText("Back");
		back.setBounds(185, 180, 70, 30);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				McVS mcvs = new McVS();
				mcvs.setVisible(true);
				setVisible(false);
			}
		});
		
		add(Name);
		add(Desc);
		add(name);
		add(desc);
		add(back);
		add(Path);
		add(path);
	}
}
