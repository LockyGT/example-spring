package com.solucionesdigitales.test.unit;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.solucionesdigitales.app.Application;
import com.solucionesdigitales.app.controller.UserController;
import com.solucionesdigitales.app.entity.User;
import com.solucionesdigitales.app.repository.UserRepository;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestPropertySource(locations = { "classpath:application_test.properties" })
public class UserTestCase {
	@Autowired
	UserRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Before
	public void setup() {
		LOGGER.info("INICIALIZANDO COMPONENTES...");
	}
	
	@Test
	public void t1_agregandoUser() {
		User user = new User();
		long respuestaEsperada = 1L;
		user.setEdad(10);
		user.setName("Israel");
		user.setEmail("isnavest@hotmail.com");
		user.setSexo("H");
		LOGGER.info("USUARIO AGREGADO: "+repository.save(user));
		Assert.assertEquals(respuestaEsperada, user.getId().longValue());
		LOGGER.info(" t1_agregarUser ----->");
	}
	
	@Test
	public void t2_editarUser() {
		User user = new User();
		int edadEsperada = 20;
		user.setId(1);
		user.setEdad(20);
		user.setName("Israel");
		user.setEmail("isnavest@hotmail.com");
		user.setSexo("H");
		LOGGER.info("USUARIO ACTUALIZADO: "+repository.save(user));
		
		Optional<User> userDb = repository.findById(1);
		
		Assert.assertEquals(edadEsperada, userDb.get().getEdad());
		LOGGER.info(" t2_actualizarUser ----->");
	}
	
	
	
	@Test
	public void t3_getUsers() {
		
		LOGGER.info("<----- t3_getUsers");
		int valorEsperado = 1;
		List<User> usuarios = (List<User>) repository.findAll();
		LOGGER.info("Usuarios: "+ usuarios.size());
		Assert.assertEquals(valorEsperado, usuarios.size());
		LOGGER.info(" t3_getUsers ----->");
	}
	
	@Test
	public void t4_getUsersBySex() {
		LOGGER.info("<----- t4_getUsersBySex");
		int valorEsperado = 1;
		List<User> usuarios = (List<User>) repository.findBySexo("H");
		LOGGER.info("Usuarios: "+ usuarios.size());
		Assert.assertEquals(valorEsperado, usuarios.size());
		LOGGER.info(" t4_getUsersBySex ----->");
	}
	
	@Test
	public void t5_deleteUser() {
		LOGGER.info("<----- t5_getUsers");
		User user = new User();
		int edadEsperada = 20;
		user.setId(1);
		user.setEdad(20);
		user.setName("Israel");
		user.setEmail("isnavest@hotmail.com");
		user.setSexo("H");
		repository.delete(user);
		LOGGER.info("USUARIO ELIMINADO");
		Assert.assertFalse(repository.existsById(1));
		LOGGER.info(" t5_getUsers ----->");
	}
	
	
}