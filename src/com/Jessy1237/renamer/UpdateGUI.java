package com.Jessy1237.renamer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UpdateGUI extends JFrame{
	public JButton yes;
	public JButton no;
	public static JLabel a;
	public static JTextArea JTA;
	public JScrollPane JSP;
	
	public UpdateGUI(){
		this.setTitle("Minecraft Version Switcher: Update");
		this.setResizable(false);
		this.setSize(new Dimension(480, 150));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JTA = new JTextArea(10, 20);
		JTA.setEditable(false);
		JTA.setBounds(10, 30, 440, 60);
		
		JSP = new JScrollPane(JTA);
		JSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setPreferredSize(new Dimension(15, 60));
		JSP.setLocation(450, 30);
		
		yes = new JButton();
		yes.setText("Yes");
		yes.setBounds(102, 90, 60, 30);
		
		no = new JButton();
		no.setText("No");
		no.setBounds(342, 90, 60, 30);
		
		a = new JLabel();
		a.setFont(new Font("ARIAL", Font.PLAIN, 14));
		a.setBounds(10, 5, 460, 20);

		
		yes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dLoadJars.v = "McVS";
				Download.c = 0;
				setVisible(false);
				Download p = new Download();
				p.setVisible(true);
			}
		});
		
		no.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Update.ver.delete();
				Update.dir.delete();
				setVisible(false);
				Opener o = new Opener();
				o.setVisible(true);
			}
		});
		
		add(a);
		add(JTA);
		add(JSP);
		add(yes);
		add(no);
	}
}
