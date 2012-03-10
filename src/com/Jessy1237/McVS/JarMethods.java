package com.Jessy1237.McVS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JarMethods extends JFrame {

	public static HashMap<String, String> cJar = new HashMap<String, String>();
	public static HashMap<String, String> names = new HashMap<String, String>();

	public static void addJar(String jar) throws IOException {
		int size = names.size() + 1;
		String c = "custom" + size;
		names.put(c, jar);
		cJar.put(jar, c);
		Switch.getFolder(jar).mkdir();
		McVS.model.add(McVS.list.getModel().getSize(), "Play " + jar);
		write();
	}

	public static void removeJar(String jar) throws IOException, ClassNotFoundException {
		String name = cJar.get(jar);
		int YesNo = JOptionPane.showConfirmDialog(null, " Are you sure you would like to remove " + jar + " jar. \n The mods folder will be deleted too if empty.", "Minecraft Version Switcher: Remove Jar", 1);
		if (YesNo == 0) {
			if (!name.equals(McVS.mcver)) {
				names.remove(name);
				cJar.remove(jar);
				Switch.getFile(jar).delete();
				Switch.getFolder(jar).delete();
				write();
				McVS.model.removeAllElements();
				read();
			} else {
				JOptionPane.showMessageDialog(null, "Please switch to another version before removal!", "Minecraft Version Switcher: Remove Jar", 1);
			}
		}
	}

	public static String getJarName(String jar) {
		return names.get(jar);
	}

	public static String getJar(String jar) {
		return cJar.get(jar);
	}

	public static void write() throws IOException {
		if (!getFolder().exists())
			getFolder().mkdir();
		if (!getFile("names").exists())
			getFile("names").createNewFile();
		if (!getFile("cJar").exists())
			getFile("cJar").createNewFile();
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
	public static void read() throws IOException, ClassNotFoundException {
		if (!getFolder().exists())
			getFolder().mkdir();
		if (!getFile("names").exists()) {
			getFile("names").createNewFile();
			names.put("1.7", "1.7");
			names.put("1.8", "1.8");
			names.put("1.0", "1.0");
			names.put("1.1", "1.1");
			names.put("1.2", "1.2");
			write();
		}
		if (!getFile("cJar").exists())
			getFile("cJar").createNewFile();
		FileInputStream f = new FileInputStream(getFile("names"));
		ObjectInputStream in = new ObjectInputStream(f);
		names = (HashMap<String, String>) in.readObject();
		in.close();
		f = new FileInputStream(getFile("cJar"));
		in = new ObjectInputStream(f);
		cJar = (HashMap<String, String>) in.readObject();
		in.close();

		if (names.containsValue("1.7") == false)
			names.put("1.7", "1.7");
		if (names.containsValue("1.8") == false)
			names.put("1.8", "1.8");
		if (names.containsValue("1.0") == false)
			names.put("1.0", "1.0");
		if (names.containsValue("1.1") == false)
			names.put("1.1", "1.1");
		if (names.containsValue("1.2") == false)
			names.put("1.2", "1.2");

		Iterator it = names.values().iterator();
		while (it.hasNext()) {
			String i = (String) it.next();
			String s = i;
			if (s.equals("1.1") || s.equals("1.2") || s.equals("1.0")) {
				s = "Play Minecraft " + s;
			} else {
				if (s.equals("1.8") || s.equals("1.7")) {
					s = "Play Minecraft Beta " + s;
				} else {
					s = "Play " + s;
				}
			}
			McVS.model.add(McVS.list.getModel().getSize(), s);
		}
	}

	public static File getFile(String name) {
		File file = null;
		if (McVS.osName.contains("win")) {
			if (name.equals("names")) {
				file = new File(McVS.Windir, "/bin/McVS/names.db");
			} else {
				file = new File(McVS.Windir, "/bin/McVS/cJar.db");
			}
		}
		if (McVS.osName.contains("mac")) {
			if (name.equals("names")) {
				file = new File(McVS.dir, "/bin/McVS/names.db");
			} else {
				file = new File(McVS.dir, "/bin/McVS/cJar.db");
			}
		}
		return file;
	}

	public static File getFolder() {
		File file = null;
		if (McVS.osName.contains("win")) {
			file = new File(McVS.Windir, "/bin/McVS");
		}
		if (McVS.osName.contains("mac")) {
			file = new File(McVS.dir, "/bin/McVS");
		}
		return file;
	}
}
