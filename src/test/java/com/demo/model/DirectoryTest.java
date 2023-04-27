package com.demo.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class DirectoryTest {

    @Test
    public void testDirectory() {
	Directory testDirectory = new Directory("/");
	assertNotNull(testDirectory.getLabel());
    }

    @Test
    public void testGetLabel() {
	Directory testDirectory = new Directory("/");
	assertEquals("/", testDirectory.getLabel());
    }

    @Test
    public void testSetLabel() {
	Directory testDirectory = new Directory("/");
	testDirectory.setLabel("pagina");
	assertEquals("pagina", testDirectory.getLabel());
    }

    @Test
    public void testGetItems() {
	Directory testDirectory = new Directory("/");
	List<Items> items = new ArrayList<>();
	testDirectory.setLabel("pagina");
	items.add(new Items("pagina", "/pagina/pagina.xhtml"));
	items.add(new Items("reporte", "/pagina/reporte/reporte.xhtml"));
	testDirectory.setItems(items);
	assertNotNull(testDirectory.getItems());
    }

    @Test
    public void testSetItems() {
	Directory testDirectory = new Directory("/");
	List<Items> items = new ArrayList<>();
	testDirectory.setLabel("pagina");
	items.add(new Items("pagina", "/pagina/pagina.xhtml"));
	items.add(new Items("reporte", "/pagina/reporte/reporte.xhtml"));
	testDirectory.setItems(items);
	assertThatNoException();
    }

    @Test
    public void testGetDirectories() {
	Directory testDirectory = new Directory("/");
	Directory testDirectory2 = new Directory("/pagina/");
	Directory testDirectory3 = new Directory("/pagina/nomina/");
	Map<String, Directory> directories = new HashMap<>();
	directories.put("1", testDirectory);
	directories.put("2", testDirectory2);
	directories.put("3", testDirectory3);
	testDirectory.setDirectories(directories);
	assertThat(testDirectory.getDirectories().size() > 0);
    }

    @Test
    public void testSetDirectories() {
	Directory testDirectory = new Directory("/");
	Directory testDirectory2 = new Directory("/pagina/");
	Directory testDirectory3 = new Directory("/pagina/nomina/");
	Map<String, Directory> directories = new HashMap<>();
	directories.put("1", testDirectory);
	directories.put("2", testDirectory2);
	directories.put("3", testDirectory3);
	testDirectory.setDirectories(directories);
	assertNotNull(testDirectory.getDirectories());

    }

}
