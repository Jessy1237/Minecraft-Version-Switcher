package com.Jessy1237.renamer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import net.minecraft.Util;

@SuppressWarnings("serial")
public class Login extends JFrame {

	public JButton gLogin;
	public JLabel a;
	public static JLabel b;
	public JLabel c;
	public JLabel d;
	public JLabel e;
	public JTextField user;
	public JPasswordField pass;
	public static String User;
	public static String Pass;
	public static int login = 0;
	
	public Login(){
		this.setTitle("Minecraft Version Switcher: Login");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(370, 150));
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.gLogin = new JButton();
		this.gLogin.setText("Login");
		this.gLogin.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				User = user.getText();
				Pass = pass.getText();
				try {
					pLogin();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		a = new JLabel();
		a.setText("Type in your Minecraft Username and Password");
		a.setBounds(30, 5, 400, 20);
		a.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		b = new JLabel();
		b.setText("");
		b.setBounds(15, 50, 400, 20);
		b.setFont(new Font("Arial", Font.BOLD, 14));
		
		c = new JLabel();
		c.setText("then Click Login.");
		c.setBounds(125, 30, 200, 20);
		c.setFont(new Font("Arial", Font.PLAIN, 14));
		
		d = new JLabel();
		d.setText("Username:");
		d.setBounds(58, 76, 80, 20);
		d.setFont(new Font("Arial", Font.PLAIN, 14));
		
		e = new JLabel();
		e.setText("Password:");
		e.setBounds(58, 100, 80, 20);
		e.setFont(new Font("Arial", Font.PLAIN, 14));
		
		user = new JTextField("");
		user.setBounds(130, 76, 80, 20);
		user.setFont(new Font("Arial", Font.PLAIN, 14));
		
		pass = new JPasswordField("");
		pass.setBounds(130, 100, 80, 20);
		pass.setFont(new Font("Arial", Font.PLAIN, 14));
		
		gLogin.setBounds(220, 84, 80, 30);
		gLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		
		add(a);
		add(c);
		add(b);
		add(d);
		add(user);
		add(gLogin);
		add(pass);
		add(e);
	}
	
	/*
	Referenced class from minecraft launcher, Launcherframe class, Loginform class and Util class.
	All under package net.minecraft. Tweaked the doLogin() so it fits the new parameters.
	*/
	public void pLogin() throws IOException{
		String result;
        String parameters = (new StringBuilder("user=")).append(URLEncoder.encode(User, "UTF-8"))
        .append("&password=").append(URLEncoder.encode(Pass, "UTF-8")).append("&version=").append(13).toString();
        result = Util.excutePost("https://login.minecraft.net/", parameters);
        if(result == null)
        {
            showError("Can't connect to minecraft.net");
            return;
        }else{
        	if(!result.contains(":")){
           		if(result.trim().equals("Bad login")){
                	showError("Login failed, Bad Login");
                	return;
           		}else{
           			if(result.trim().equals("Old version")){
                		showError("Outdated launcher");
                		return;
            		} else {
                		showError(result);
                		return;
            		}
           		}
        	}else{
            	if(dLoadJars.v.equals("1.8")){
                	setVisible(false);
            		dLoadJars.DL18_actionPerformed();
            		return;
            	}
            	if(dLoadJars.v.equals("1.7")){
                	setVisible(false);
            		dLoadJars.DL17_actionPerformed();
            		return;
            	}
            	if(dLoadJars.v.equals("1.0")){
                	setVisible(false);
            		dLoadJars.DL1_actionPerformed();
            		return;
            	}
        	}
        }
	}
	
	public static void showError(String error){
		b.setText("Error: " + error + ". Try Again!");
	}
}
