package com.solucionesdigitales.app.service;

import java.util.List;

import com.solucionesdigitales.app.entity.User;

public interface UserService {
	public User insertarUSer(User user);
	public User actualizarUSer(User user);
	public boolean eliminarUser(User user);
	public List<User> verUSers();
	public List<User> verPorSexo(String sexo);
}
