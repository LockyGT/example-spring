package com.solucionesdigitales.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.solucionesdigitales.app.entity.User;

public interface UserRepository extends CrudRepository <User, Integer>{
	public List<User> findBySexo(String sexo);
}
