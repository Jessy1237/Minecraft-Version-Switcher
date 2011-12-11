package com.Jessy1237.renamer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UpdateBugfixGUI extends JFrame{
	
	public JTextArea JTA;
	public JButton B;
	
	public UpdateBugfixGUI(){
		this.setTitle("Minecraft Version Switcher: Bugfixes");
		this.setResizable(false);
		this.setSize(new Dimension(580, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		
		JTA = new JTextArea();
		JTA.setText("");
		JTA.setLineWrap(true);
		JTA.setEditable(false);
		
		B = new JButton();
		B.setText("Close");
		B.setSize(60, 30);
		B.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateGUI u = new UpdateGUI();
				u.a.setText("Update is available, Would you like to update to version " + Update.version + "?");
				setVisible(false);
			}
		});
		
		add(JTA, BorderLayout.CENTER);
		add(B, BorderLayout.SOUTH);
	}
}
