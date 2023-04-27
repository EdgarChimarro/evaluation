package com.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Directory;
import com.demo.service.Filesystem;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoApplication {

    public static void main(String[] args) {

	ObjectMapper mapper = new ObjectMapper();
	String nestedJsonPayload = "";
	String path = "src/main/resources/menu.json";

	List<String> lista = new ArrayList<>();
	lista.add("/paginas/compras/procesos/facturaProveedor.xhtml");
	lista.add("/paginas/compras/procesos/recepcionProveedor.xhtml");
	lista.add("/paginas/compras/Reportes/reporteA.xhtml");
	lista.add("/paginas/compras/Reportes/reporteB.xhtml");
	lista.add("/paginas/nomina/configuracion/empleados/empleado.xhtml");

	for (String item : lista) {
	    Filesystem.create(item);
	}

	try {
	    nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter()
		    .writeValueAsString(Directory.root.getDirectories());

	    FileWriter file = new FileWriter(path);
	    file.write(nestedJsonPayload);
	    file.close();

	} catch (IOException e) {
	    e.printStackTrace();

	}

    }

}
