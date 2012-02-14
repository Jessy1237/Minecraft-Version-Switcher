package com.Jessy1237.McVS;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Emailer extends JFrame{

	public static String username;
	
	public static JButton Back;
	public JButton Send;
	public JLabel a;
	public JLabel b;
	public JLabel c;
	public JTextField email;
	public JTextField user;
	public JTextArea msg;
	
	public Emailer(){
		this.setTitle("Minecraft Version Switcher: Found a Bug?");
		this.setSize(new Dimension(580, 250));
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Send = new JButton();
		Send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Send_actionPerformed();
					JOptionPane.showMessageDialog(null, "The Bug Message has been sent!");
					msg.setText("Message Here");
					user.setText("");
				} catch (MessagingException e1) {
					JOptionPane.showMessageDialog(null, "Unable To Send Email, Is you Internet working?", "Minecraft Version Switcher: Found a Bug?", 1);
				}
			}
		});
		
		Back = new JButton();
		Back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				McVS o = new McVS();
				o.setVisible(true);
			}
		});
		
		Send.setText("Send");
		Send.setBounds(385, 188, 100, 30);
		
		Back.setText("Back");
		Back.setBounds(95, 188, 100, 30);
		
		a = new JLabel();
		a.setText("Please be Brief!");
		a.setFont(new Font("Arial", Font.PLAIN, 14));
		a.setBounds(10, 10, 500, 20);
		
		b = new JLabel();
		b.setText("(Optional) Username:");
		b.setFont(new Font("Arial", Font.PLAIN, 14));
		b.setBounds(10, 40, 200, 20);
		
		user = new JTextField();
		user.setBounds(145, 40, 150, 20);
		
		c = new JLabel();
		c.setText("(Optional)Email:");
		c.setFont(new Font("Arial", Font.PLAIN, 14));
		c.setBounds(310, 40, 200, 20);
		
		email = new JTextField();
		email.setBounds(412, 40, 150, 20);
		
		msg = new JTextArea();
		msg.setEditable(true);
		msg.setEnabled(true);
		msg.setLineWrap(true);
		msg.setText("Message Here, Email is so i can email you back if need be.");
		msg.setSize(535, 105);
		msg.setLocation(20, 75);
		
		add(a);
		add(b);
		add(user);
		add(c);
		add(email);
		add(msg);
		add(Back);
		add(Send);
	}
	
	public static void sendEmail(String host, String from, String Subject, String msg) throws MessagingException{
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.password", "** PASS HERE**");
	    props.put("mail.smtp.auth", "true");

	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));

	    String[] to = {"j.e.s.s.e.b.o.yvs@gmail.com"};
	    
	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    for( int i=0; i < to.length; i++ ) {
	        toAddress[i] = new InternetAddress(to[i]);
	    }

	    for( int i=0; i < toAddress.length; i++) {
	        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(Subject);
	    message.setText(msg);
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, from, "** PASS HERE**");
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	}

	public void Send_actionPerformed() throws MessagingException{
		if(user.getText().equals("")){
			username = "Anon.";
		}else{
			username = user.getText();
		}
		String msg1 = msg.getText() + "\n" + "From " + username + ", " + email.getText();
		sendEmail("smtp.gmail.com", "mcvs.bugfinder@gmail.com", "Found a Bug", msg1);
	}
}
