package com.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @author HP
 *
 */
@Data
public class Directory {

    public static Directory root = new Directory("/");

    private String label;
    private List<Items> items = new ArrayList<>();
    private Map<String, Directory> directories = new HashMap<>();

    public Directory(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public List<Items> getItems() {
	return items;
    }

    public void setItems(List<Items> items) {
	this.items = items;
    }

    public Map<String, Directory> getDirectories() {
	return directories;
    }

    public void setDirectories(Map<String, Directory> directories) {
	this.directories = directories;
    }

}
