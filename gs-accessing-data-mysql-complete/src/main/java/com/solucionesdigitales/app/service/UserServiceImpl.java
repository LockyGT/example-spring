package com.solucionesdigitales.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucionesdigitales.app.entity.User;
import com.solucionesdigitales.app.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repository;
	
	@Override
	public User insertarUSer(User user) {
		repository.save(user);
		return null;
	}

	@Override
	public User actualizarUSer(User user) {
		repository.save(user);
		return null;
	}

	@Override
	public boolean eliminarUser(User user) {
		repository.delete(user);
		return false;
	}

	@Override
	public List<User> verUSers() {

		return (List<User>) repository.findAll();
	}

	@Override
	public List<User> verPorSexo(String sexo) {
		// TODO Auto-generated method stub
		return repository.findBySexo(sexo);
	}

}
