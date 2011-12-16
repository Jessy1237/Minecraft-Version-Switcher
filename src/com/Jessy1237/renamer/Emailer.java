package com.Jessy1237.renamer;

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
	int c = 0;
	
	public static JButton Back;
	public JButton Send;
	public JLabel a;
	public JLabel b;
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
				if(c == 1){
					setVisible(false);
					Opener o = new Opener();
					o.setVisible(true);
				}
				if(c == 0){	
					try {
						Send_actionPerformed();
						Send.setText("Done");
						Send.setBounds(385, 190, 100, 30);
						c = 1;
					} catch (MessagingException e1) {
						JOptionPane.showMessageDialog(null, "Unable To Send Email, Is you Internet working?", "Minecraft Version Switcher: Found a Bug?", 1);
					}
				}
			}
		});
		
		Back = new JButton();
		Back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				Opener o = new Opener();
				o.setVisible(true);
			}
		});
		
		Send.setText("Send");
		Send.setBounds(385, 190, 100, 30);
		
		Back.setText("Back");
		Back.setBounds(95, 190, 100, 30);
		
		a = new JLabel();
		a.setText("Please be Brief; only tell me what happened and how!");
		a.setFont(new Font("Arial", Font.PLAIN, 14));
		a.setBounds(10, 10, 500, 20);
		
		b = new JLabel();
		b.setText("(Optional) Username:");
		b.setFont(new Font("Arial", Font.PLAIN, 14));
		b.setBounds(25, 40, 200, 20);
		
		user = new JTextField();
		user.setBounds(160, 40, 150, 20);
		
		msg = new JTextArea();
		msg.setText("Message Here");
		msg.setBounds(10, 75, 560, 110);
		
		add(a);
		add(b);
		add(user);
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
	    props.put("mail.smtp.password", "*PASSWORD HERE*");
	    props.put("mail.smtp.auth", "true");

	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));

	    String[] to = {"j.e.s.s.e.b.o.yvs@gmail.com"};
	    
	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    for( int i=0; i < to.length; i++ ) {
	        toAddress[i] = new InternetAddress(to[i]);
	    }
	    System.out.println(Message.RecipientType.TO);

	    for( int i=0; i < toAddress.length; i++) {
	        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject(Subject);
	    message.setText(msg);
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, from, "*PASSWORD HERE");
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	}

	public void Send_actionPerformed() throws MessagingException{
		if(user.getText().equals("")){
			username = "Anon.";
		}else{
			username = user.getText();
		}
		String msg1 = msg.getText() + "\n" + "From " + username;
		sendEmail("smtp.gmail.com", "mcvs.bugfinder@gmail.com", "Found a Bug", msg1);
	}
}
