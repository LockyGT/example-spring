package com.solucionesdigitales.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.solucionesdigitales.app.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{
	
}
