package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.EnderecoEntity;
import com.project.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public EnderecoEntity cadastrarEndereco(EnderecoEntity endereco) {
		return this.enderecoRepository.save(endereco);
	}
	
	public List<EnderecoEntity> consultarEndereco() {
		return this.enderecoRepository.findAll();
	}
	
	public EnderecoEntity atualizarEndereco(EnderecoEntity endereco) {
		return this.enderecoRepository.save(endereco);
	}	
}