package com.project.model.service;


import java.util.List;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.project.entity.LoginEntity;
import com.project.repository.LoginRepository;
import com.project.service.LoginService;

public class LoginTests extends AbstractIntegrationTests {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginService loginService;
	
	/*
	 * ========================= CADASTRAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarLoginMustPass() {
		LoginEntity login = new LoginEntity();
		login.setUsername("username");
		login.setSenha("senha");
		this.loginService.cadastrarLogin(login);
		Assert.assertNotNull(login.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarLoginMustFailUsernameNotNull() {
		LoginEntity login = new LoginEntity();
		login.setUsername(null);
		login.setSenha("senha");
		this.loginService.cadastrarLogin(login);
		Assert.assertNotNull(login.getId());
	}
	
	@Test(expected = ValidationException.class)
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void cadastrarLoginMustFailSenhaNotNull() {
		LoginEntity login = new LoginEntity();
		login.setUsername("username");
		login.setSenha(null);
		this.loginService.cadastrarLogin(login);
		Assert.assertNotNull(login.getId());
	}

	/*
	 * ========================= CONSULTAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void consultarLoginMustPass() {
		List<LoginEntity> logins = this.loginRepository.findAll();
		Assert.assertEquals(logins.size(), 1);
		
	}
	
	/*
	 * ========================= ATUALIZAR =========================
	 */
	
	@Test
	@Sql({"/dataset/truncate.sql",
	"/dataset/insert.sql"})
	public void atualizarLoginMustPass() {
		LoginEntity login = this.loginRepository.findById(1000L).orElse(null);
		login.setUsername("username");
		this.loginService.atualizarLogin(login);
		Assert.assertTrue(login.getUsername().equals("username"));
	}	
}