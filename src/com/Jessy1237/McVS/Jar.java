package com.Jessy1237.McVS;

import java.io.File;
import java.io.Serializable;

public class Jar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2806246320317726259L;
	private String name, desc;
	private File jar;
	
	public Jar(String name, File jar, String desc){
		this.name = name;
		this.jar = jar;
		this.desc = desc;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public File getJar(){
		return this.jar;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
}
