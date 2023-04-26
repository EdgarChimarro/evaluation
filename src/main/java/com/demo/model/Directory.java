package com.demo.model;

import java.util.HashMap;

import lombok.Data;

/**
 * @author HP
 *
 */
@Data
public class Directory {
	
	 private String pathName;
     private HashMap<String, String> files = new HashMap<>();
     private HashMap<String, Directory> directories = new HashMap<>();
     
     public Directory(String pathName) {
         this.pathName = pathName;
     }

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public HashMap<String, String> getFiles() {
		return files;
	}

	public void setFiles(HashMap<String, String> files) {
		this.files = files;
	}

	public HashMap<String, Directory> getDirectories() {
		return directories;
	}

	public void setDirectories(HashMap<String, Directory> directories) {
		this.directories = directories;
	}
     
     
}
