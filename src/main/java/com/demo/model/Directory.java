package com.demo.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * @author HP
 *
 */
@Data
public class Directory {

    private String label;
    private HashMap<String, String> items = new HashMap<>();
    private Map<String, Directory> directories = new HashMap<String, Directory>();

    public Directory(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public HashMap<String, String> getItems() {
	return items;
    }

    public void setItems(HashMap<String, String> items) {
	this.items = items;
    }

    public Map<String, Directory> getDirectories() {
	return directories;
    }

    public void setDirectories(Map<String, Directory> directories) {
	this.directories = directories;
    }

}
