package com.Jessy1237.McVS.Management;

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

import com.Jessy1237.McVS.Jar;
import com.Jessy1237.McVS.McVS;

@SuppressWarnings("serial")
public class Util extends JFrame {

	public static HashMap<String, Jar> jars = new HashMap<String, Jar>();

	public static void addJar(Jar jar) throws IOException {
		jars.put(jar.getName(), jar);
		getFolder(jar.getName()).mkdir();
		McVS.model.add(McVS.list.getModel().getSize(), "Play " + jar.getName());
		write();
	}

	public static void removeJar(Jar jar) throws IOException, ClassNotFoundException {
		String name = jar.getName();
		int YesNo = JOptionPane.showConfirmDialog(null, " Are you sure you would like to remove " + jar.getName() + " jar. \n The mods folder will be deleted too if empty.", "Minecraft Version Switcher: Remove Jar", 1);
		if (YesNo == 0) {
			if (!name.equals(McVS.mcver)) {
				jars.remove(name);
				jar.getJar().delete();
				getFolder(jar.getName()).delete();
				write();
				McVS.model.removeAllElements();
				read();
			} else {
				JOptionPane.showMessageDialog(null, "Please switch to another version before removal!", "Minecraft Version Switcher: Remove Jar", 1);
			}
		}
	}

	public static void write() throws IOException {
		if (!getDBFolder().exists())
			getDBFolder().mkdir();
		if (!getDB().exists())
			getDB().createNewFile();
		FileOutputStream out = new FileOutputStream(getDB());
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(jars);
		oos.flush();
		oos.close();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void read() throws IOException, ClassNotFoundException {
		if (!getDBFolder().exists())
			getDBFolder().mkdir();
		if (!getDB().exists()) {
			getDB().createNewFile();
			jars.put("1.7", new Jar("1.7", getFile("1.7"), "Latest 1.7.X Minecraft Beta Jar!"));
			jars.put("1.8", new Jar("1.8", getFile("1.8"), "Latest 1.7.X Minecraft Beta Jar!"));
			jars.put("1.0", new Jar("1.0", getFile("1.0"), "Latest 1.7.X Minecraft Jar!"));
			jars.put("1.1", new Jar("1.1", getFile("1.1"), "Latest 1.7.X Minecraft Jar!"));
			jars.put("1.2", new Jar("1.2", getFile("1.2"), "Latest 1.7.X Minecraft Jar!"));
			write();
		}
		if (!getDB().exists())
			getDB().createNewFile();
		FileInputStream f = new FileInputStream(getDB());
		ObjectInputStream in = new ObjectInputStream(f);
		jars = (HashMap<String, Jar>) in.readObject();
		in.close();

		if (jars.containsKey("1.7") == false)
			jars.put("1.7", new Jar("1.7", getFile("1.7"), "Latest 1.7.X Minecraft Beta Jar!"));
		if (jars.containsKey("1.8") == false)
			jars.put("1.8", new Jar("1.8", getFile("1.8"), "Latest 1.7.X Minecraft Beta Jar!"));
		if (jars.containsKey("1.0") == false)
			jars.put("1.0", new Jar("1.0", getFile("1.0"), "Latest 1.7.X Minecraft Jar!"));
		if (jars.containsKey("1.1") == false)
			jars.put("1.1", new Jar("1.1", getFile("1.1"), "Latest 1.7.X Minecraft Jar!"));
		if (jars.containsKey("1.2") == false)
			jars.put("1.2", new Jar("1.2", getFile("1.2"), "Latest 1.7.X Minecraft Jar!"));

		Iterator it = jars.keySet().iterator();
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

	public static Jar getJar(String name) {
		if (!getDBFolder().exists())
			getDBFolder().mkdir();
		if (!getDB().exists())
			try {
				getDB().createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		Jar j = new Jar("", getcFile("null"), "");
		Iterator<Jar> it = jars.values().iterator();
		while (it.hasNext()) {
			Jar jar = it.next();
			if (jar.getName().equals(name)) {
				j = jar;
			}
		}
		return j;
	}

	public static File getDB() {
		File file = null;
		if (McVS.osName.contains("win")) {
			file = new File(McVS.Windir, "/bin/McVS/jars.db");
		} else if (McVS.osName.contains("mac")) {
			file = new File(McVS.dir, "/bin/McVS/jars.db");
		} else if (McVS.osName.contains("linux")) {
			file = new File(McVS.Lindir, "/bin/McVS/jars.db");
		}
		return file;
	}

	public static File getDBFolder() {
		File file = null;
		if (McVS.osName.contains("win")) {
			file = new File(McVS.Windir, "/bin/McVS");
		} else if (McVS.osName.contains("mac")) {
			file = new File(McVS.dir, "/bin/McVS");
		} else if (McVS.osName.contains("linux")) {
			file = new File(McVS.Lindir, "/bin/McVS");
		}
		return file;
	}

	public static File getcFile(String jar) {
		File file = null;
		if (McVS.osName.contains("win")) {
			file = new File(McVS.Windir, "/bin/" + jar + ".jar");
		} else if (McVS.osName.contains("mac")) {
			file = new File(McVS.dir, "/bin/" + jar + ".jar");
		} else if (McVS.osName.contains("linux")) {
			file = new File(McVS.Lindir, "/bin/" + jar + ".jar");
		}
		return file;
	}

	public static File getFile(String jar) {
		File file = null;
		if (McVS.osName.contains("win")) {
			if (jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("minecraft")) {
				file = new File(McVS.Windir, "/bin/" + jar + ".jar");
			} else {
				file = getcFile(jar);
			}
		} else if (McVS.osName.contains("mac")) {
			if (jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("minecraft")) {
				file = new File(McVS.dir, "/bin/" + jar + ".jar");
			} else {
				file = getcFile(jar);
			}
		} else if (McVS.osName.contains("linux")) {
			if (jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("minecraft")) {
				file = new File(McVS.Lindir, "/bin/" + jar + ".jar");
			} else {
				file = getcFile(jar);
			}
		}
		return file;
	}

	public static File getcFolder(String jar) {
		File file = null;
		if (McVS.osName.contains("win")) {
			file = new File(McVS.Windir, "/mods " + jar);
		} else if (McVS.osName.contains("mac")) {
			file = new File(McVS.dir, "/mods " + jar);
		} else if (McVS.osName.contains("linux")) {
			file = new File(McVS.Lindir, "/mods " + jar);
		}
		return file;
	}

	public static File getFolder(String jar) {
		File file = null;
		String s = jar;
		if (McVS.osName.contains("win")) {
			if (jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("1.2")) {
				s = s.replace(".", "-");
				file = new File(McVS.Windir, "/mods " + s);
			} else {
				if (jar.equals("mods")) {
					s = s.replace(".", "-");
					file = new File(McVS.Windir, "/mods");
				} else {
					file = getcFolder(jar);
				}
			}
		} else if (McVS.osName.contains("mac")) {
			if (jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("1.2")) {
				s = s.replace(".", "-");
				file = new File(McVS.dir, "/mods " + s);
			} else {
				if (jar.equals("mods")) {
					s = s.replace(".", "-");
					file = new File(McVS.dir, "/mods");
				} else {
					file = getcFolder(jar);
				}
			}
		} else if (McVS.osName.contains("linux")) {
			if (jar.equals("1.8") || jar.equals("1.7") || jar.equals("1.0") || jar.equals("1.1") || jar.equals("1.2")) {
				s = s.replace(".", "-");
				file = new File(McVS.Lindir, "/mods " + s);
			} else {
				if (jar.equals("mods")) {
					s = s.replace(".", "-");
					file = new File(McVS.Lindir, "/mods");
				} else {
					file = getcFolder(jar);
				}
			}
		}
		return file;
	}
}
