package com.demo.service;

import com.demo.model.Directory;
import com.demo.model.Items;

public class Filesystem {
    
    private Filesystem(){}

    /**
     * To create a Filesystem structure
     * @param path
     */
    public static void create(String path) {
	String[] paths = path.split("/");
	Directory p = Directory.root;
	Directory aux = null;

	for (int i = 1; i <= paths.length - 1; ++i) {
	    if (p.getDirectories().containsKey(paths[i]) && !paths[i].isEmpty()) {
		p = p.getDirectories().get(paths[i]);
	    } else if (i == paths.length - 1 && paths[i].contains(".")) {
		if (p.getDirectories().isEmpty()) {
		    p.getItems().add(new Items(paths[i], path));
		} else {
		    p.getDirectories().get(paths[i - 1]).getItems().add(new Items(paths[i], path));
		}
	    } else if (!p.getDirectories().isEmpty() && p.getDirectories().get(paths[i - 1]) != null) {
		p = p.getDirectories().get(paths[i - 1]);
		aux = new Directory(paths[i]);
		p.getDirectories().put(paths[i], aux);
	    } else {
		aux = new Directory(paths[i]);
		p.getDirectories().put(paths[i], aux);
	    }
	}
    }
}
