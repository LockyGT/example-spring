package com.solucionesdigitales.app.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solucionesdigitales.app.entity.User;
import com.solucionesdigitales.app.service.UserService;

@RestController
@RequestMapping(path="/")
public class UserController {

	@Autowired
	UserService service;
	ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("user/sexo/")
	@ResponseBody
	public List<User> getBySexo(@RequestParam(value="sexo") final String sexo) {
		return service.verPorSexo(sexo);
	}
	
	
	@GetMapping("user")
	@ResponseBody
	public List<User> obtenerUsuarios() {
		return service.verUSers();
	}
	
	@PostMapping("user")
	@ResponseBody
	public User insertarUser(@RequestBody User user) {
		
		LOGGER.debug("Recibiendo usuario " + user);
		return service.insertarUSer(user);
	}
	
	@PutMapping("user")
	@ResponseBody
	public User actualizarUser(@RequestBody User user) {
		
		LOGGER.debug("Actualizando usuario " + user);
		return service.actualizarUSer(user);
	}
	
	@DeleteMapping("user")
	@ResponseBody
	public boolean eliminarUser(@RequestBody String user) {
		User userEntity = null;
		boolean esEliminada = false;
		try {
			userEntity = mapper.readValue(user, User.class);
			service.eliminarUser(userEntity);
			esEliminada= true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.debug("Eliminando usuario " + user);
		return esEliminada;
	}
}
