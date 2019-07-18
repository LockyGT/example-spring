package com.solucionesdigitales.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solucionesdigitales.app.entity.Producto;
import com.solucionesdigitales.app.entity.User;
import com.solucionesdigitales.app.service.ProductoService;

@RestController
@RequestMapping(path="/")
public class ProductoController {

	@Autowired
	ProductoService service;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("producto")
	@ResponseBody
	public List<Producto> getProductos(){
		return service.getProductos();
	}
	
	@PostMapping("producto")
	@ResponseBody
	public Producto insertProducto(@RequestBody Producto producto){
		return service.insertProducto(producto);
	}
	
	@PutMapping("producto")
	@ResponseBody
	public Producto updateProducto(@RequestBody Producto producto){
		return service.updateProducto(producto);
	}
	
	@DeleteMapping("producto")
	@ResponseBody
	public boolean deleteProducto(@RequestBody String producto){
		Producto userEntity = null;
		boolean esEliminada = false;
		try {
			userEntity = mapper.readValue(producto, Producto.class);
			service.eliminarProducto(userEntity);
			esEliminada = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esEliminada;
	}
}
