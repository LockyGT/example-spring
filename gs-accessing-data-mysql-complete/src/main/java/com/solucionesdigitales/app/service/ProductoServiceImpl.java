package com.solucionesdigitales.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucionesdigitales.app.entity.Producto;
import com.solucionesdigitales.app.repository.ProductoRepository;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository repository;

	@Override
	public Producto insertProducto(Producto producto) {
		// TODO Auto-generated method stub
		return repository.save(producto);
	}

	@Override
	public Producto updateProducto(Producto producto) {
		// TODO Auto-generated method stub
		return repository.save(producto);
	}

	@Override
	public boolean eliminarProducto(Producto producto) {
		// TODO Auto-generated method stub
		repository.deleteAll();
		return true;
	}

	@Override
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>) repository.findAll();
	}
}
