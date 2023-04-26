package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.model.Directory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@SpringBootApplication
public class DemoApplication {
	
	private static Directory root = new Directory("/");

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		final Gson gson = new Gson();
		LinkedHashMap<Object, Object> lhm; //initiaze
		Map<String,List<Map<Object, Object>>> map;
		List<Map<Object, Object>> list;
		
		List<String> lista = new ArrayList<>();
		lista.add("/paginas/compras/procesos/facturaProveedor.xhtml");
		lista.add("/paginas/compras/procesos/recepcionProveedor.xhtml");
		lista.add("/paginas/compras/Reportes/reporteA.xhtml");
		lista.add("/paginas/compras/Reportes/reporteB.xhtml");
		lista.add("/paginas/nomina/configuracion/empleados/empleado.xhtml");
		
		 
		 
		for (String item : lista) {
			
			ls(item);	
			
		}
		
		String JSON = gson.toJson(lista);
		
		 ObjectMapper mapper = new ObjectMapper();
	        String nestedJsonPayload = "";
			try {
				nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lista);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(nestedJsonPayload);
		
	}
	
	public static void ls(String path) {
        String[] paths = path.split("/");
        Directory p = root;
        for(int i = 1;i <= paths.length - 1;++i) {
           if(p.getDirectories().containsKey(paths[i])) {
               p = p.getDirectories().get(paths[i]);
           } else if (i == paths.length - 1 && paths[i].contains(".")) {
               p.getFiles().put(paths[i-1], paths[i]);
           } else {
        	   insertLs(p, paths[i]);
           }
        }
        
   }
	
	 private static void insertLs(Directory p, String string) {
		if(!p.getDirectories().containsKey(string)) {
			p.getDirectories().put(string, p);
		} 
		
	}


}
