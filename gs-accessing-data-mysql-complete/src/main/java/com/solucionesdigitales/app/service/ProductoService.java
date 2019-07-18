package com.solucionesdigitales.app.service;

import java.util.List;

import com.solucionesdigitales.app.entity.Producto;

public interface ProductoService {
	public Producto insertProducto(Producto producto);
	public Producto updateProducto(Producto producto);
	public boolean eliminarProducto(Producto producto);
	public List<Producto> getProductos();
}
