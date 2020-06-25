package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.FormacaoEntity;
import com.project.repository.FormacaoRepository;

@Service
@Transactional
public class FormacaoService {

	@Autowired
	private FormacaoRepository formacaoRepository;
	
	public FormacaoEntity cadastrarFormacao(FormacaoEntity formacao) {
		return this.formacaoRepository.save(formacao);
	}
	
	public List<FormacaoEntity> consultarFormacao() {
		return this.formacaoRepository.findAll();
	}
	
	public FormacaoEntity atualizarFormacao(FormacaoEntity formacao) {
		return this.formacaoRepository.save(formacao);
	}
}