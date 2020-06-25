package com.project.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.LoginEntity;
import com.project.repository.LoginRepository;
import com.project.service.LoginService;

@Component
@RestController
@RequestMapping("/api/login")
public class LoginResource {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/consult")
	public List<LoginEntity> consultar() {
		return this.loginRepository.findAll();
	}
}