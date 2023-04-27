package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.model.Directory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class DemoApplication {

    private static Directory root = new Directory("/");    

    public static void main(String[] args) {
	// SpringApplication.run(DemoApplication.class, args);

	List<String> lista = new ArrayList<>();
	lista.add("/paginas/compras/procesos/facturaProveedor.xhtml");
	lista.add("/paginas/compras/procesos/recepcionProveedor.xhtml");
	lista.add("/paginas/compras/Reportes/reporteA.xhtml");
	lista.add("/paginas/compras/Reportes/reporteB.xhtml");
	lista.add("/paginas/nomina/configuracion/empleados/empleado.xhtml");

	for (String item : lista) {
	    completar(item);
	}	

	ObjectMapper mapper = new ObjectMapper();
	String nestedJsonPayload = "";
	try {
	    nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
	    System.out.println(nestedJsonPayload);
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}
	
    }

    public static void completar(String path) {
	String[] paths = path.split("/");
	Directory p = root;
	Directory aux = null;

	for (int i = 1; i <= paths.length - 1; ++i) {
	    if (paths[i].isEmpty()) {
		continue;
	    }

	    if (p.getDirectories().containsKey(paths[i]) && !paths[i].isEmpty()) {
		p = p.getDirectories().get(paths[i]);
	    } else if (i == paths.length - 1 && paths[i].contains(".")) {
		if (p.getDirectories().isEmpty()) {
		    p.getItems().put(path, paths[i]);
		} else {
		    p.getDirectories().get(paths[i - 1]).getItems().put(path, paths[i]);
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
