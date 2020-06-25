package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.LoginEntity;
import com.project.repository.LoginRepository;

@Service
@Transactional
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public LoginEntity cadastrarLogin(LoginEntity login) {
		return this.loginRepository.save(login);
	}
	
	public List<LoginEntity> consultarLogin() {
		return this.loginRepository.findAll();
	}
	
	public LoginEntity atualizarLogin(LoginEntity login) {
		return this.loginRepository.save(login);
	}
}