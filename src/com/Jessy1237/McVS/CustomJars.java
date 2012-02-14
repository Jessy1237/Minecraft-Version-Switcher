package com.Jessy1237.McVS;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class CustomJars extends JFrame{

	public static JList list;
	public static DefaultListModel model = new DefaultListModel();
	public JScrollPane pane;
	public JLabel a;
	public JButton back;
	public JButton play;
	public JButton add;
	public JButton remove;
	
	public static HashMap <String,String>cJar = new HashMap<String,String>();
	public static HashMap <String,String>names = new HashMap<String,String>();
	
	public CustomJars(){
		setTitle("Minecraft Version Switcher: Custom Jars");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(480, 500));
		setResizable(true);
		setLocationRelativeTo(null);
		
		back = new JButton();
		back.setText("Back");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				McVS mcvs = new McVS();
				mcvs.setVisible(true);
				setVisible(false);
			}
		});
		
		play = new JButton();
		play.setText("Switch");
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Please select a Jar!", "Minecraft Version Switcher: Remove Jar", 1);
				}else{
					String s = (String)list.getSelectedValue();
					s = s.replace("Play ", "");
					System.out.println(s);
					Switch S = new Switch();
					try {
						S.switchJar(s);
						McVS.mcver();
						a.setText("Current Selected Version: " + McVS.mcver);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		add = new JButton();
		add.setText("Add Jar");
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = JOptionPane.showInputDialog(null, "What is the jar called excluding '.jar'", "Minecraft Version Switcher: Add Jar", 1);
				if(s.equals(null) || s.equals("") || s.equals(" ")){
					JOptionPane.showMessageDialog(null, "Please Specify the Jar Name next time!", "Minecraft Version Switcher: Add Jar", 1);
				}else{
					if(Switch.getFile(s).exists()){
						try {
							addJar(s);
							JOptionPane.showMessageDialog(null, "Done!", "Minecraft Version Switcher: Add Jar", 1);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, " The jar " + s + " does not exist! \n Make sure the jar is in your \n bin Folder!", "Minecraft Version Switcher: Add Jar", 1);
					}
				}
			}
		});
		
		remove = new JButton();
		remove.setText("Remove Jar");
		remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Please select a Jar!", "Minecraft Version Switcher: Remove Jar", 1);
				}else{
					String s = (String)list.getSelectedValue();
					s = s.replace("Play ", "");
					try {
						removeJar(s);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Done!", "Minecraft Version Switcher: Remove Jar", 1);
				}
			}
		});
		
		add.setBounds(355, 155, 80, 30);
		back.setBounds(355, 275, 80, 30);
		play.setBounds(355, 235, 80, 30);
		remove.setBounds(340, 195, 110, 30);
		
		a = new JLabel();
		a.setText("Current Selected Version: " + McVS.mcver);
		a.setBounds(10, 440, 460, 20);
		a.setFont(new Font("Arial", Font.PLAIN, 14));
		
		list = new JList(model);
		
		add(list);
		
		if(!model.isEmpty()) model.removeAllElements();
		
		try {
			read();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		
		pane = new JScrollPane(list);
		pane.setBounds(10, 10, 320, 430);
		
		add(pane);
		add(add);
		add(play);
		add(back);
		add(remove);
		add(a);
		
	}
	
	public static void addJar(String jar) throws IOException{
		int size = names.size() + 1;
		String c = "custom" + size;
		names.put(c,jar);
		cJar.put(jar, c);
		Switch.getFolder(jar).mkdir();
		model.add(list.getModel().getSize(), "Play " + jar);
		write();
	}
	
	public static void removeJar(String jar) throws IOException, ClassNotFoundException{
		String name = cJar.get(jar);
		int YesNo = JOptionPane.showConfirmDialog(null, " Are you sure you would like to remove " + jar + " jar. \n The mods folder will be deleted too if empty.", "Minecraft Version Switcher: Remove Jar", 1);
		if(YesNo == 0){
			if(!name.equals(McVS.mcver)){
				names.remove(name);
				cJar.remove(jar);
				Switch.getFile(jar).delete();
				Switch.getFolder(jar).delete();
				write();
				model.removeAllElements();
				read();
			}else{
				JOptionPane.showMessageDialog(null, "Please switch to another version before removal!", "Minecraft Version Switcher: Remove Jar", 1);
			}
		}
	}
	
	public static String getJarName(String jar){
		return names.get(jar);
	}
	
	public static String getJar(String jar){
		return cJar.get(jar);
	}
	
	public static void write() throws IOException{
		if(!getFolder().exists()) getFolder().mkdir();
		if(!getFile("names").exists()) getFile("names").createNewFile();
		if(!getFile("cJar").exists()) getFile("cJar").createNewFile();
		FileOutputStream out = new FileOutputStream(getFile("names"));
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(names);
		oos.flush();
		oos.close();
		out = new FileOutputStream(getFile("cJar"));
		oos = new ObjectOutputStream(out);
		oos.writeObject(cJar);
		oos.flush();
		oos.close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void read() throws IOException, ClassNotFoundException{
		FileInputStream f = new FileInputStream(getFile("names"));
		ObjectInputStream in = new ObjectInputStream(f);
		names = (HashMap<String,String>) in.readObject();
		in.close();
		f = new FileInputStream(getFile("cJar"));
		in = new ObjectInputStream(f);
		cJar = (HashMap<String,String>) in.readObject();
		in.close();
		
		Iterator it = names.values().iterator();
		while(it.hasNext()){
			String i = (String)it.next();
			String s = "Play " + i;
			System.out.println(s);
			System.out.println(i);
			model.add(list.getModel().getSize(), s);
		}
	}
	
	public static File getFile(String name){
		File file = null;
		if(McVS.osName.contains("win")){
			if(name.equals("names")){
				file = new File(McVS.Windir, "/bin/McVS/names.db");
			}else{
				file = new File(McVS.Windir, "bin/McVS/cJar.db");
			}
		}
		if(McVS.osName.contains("mac")){
			if(name.equals("names")){
				file = new File(McVS.dir, "/bin/McVS/names.db");
			}else{
				file = new File(McVS.dir, "/bin/McVS/cJar.db");
			}
		}
		return file;
	}
	
	public static File getFolder(){
		File file = null;
		if(McVS.osName.contains("win")){
			file = new File(McVS.Windir, "/bin/McVS");
		}
		if(McVS.osName.contains("mac")){
			file = new File(McVS.dir, "/bin/McVS");
		}
		return file;
	}
}
