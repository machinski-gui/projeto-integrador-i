package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.EmpresaEntity;
import com.project.repository.EmpresaRepository;

@Service
@Transactional
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public EmpresaEntity cadastrarEmpresa(EmpresaEntity empresa) {
		return this.empresaRepository.save(empresa);
	}
	
	public List<EmpresaEntity> consultarEmpresa() {
		return this.empresaRepository.findAll();
	}
	
	public EmpresaEntity atualizarEmpresa(EmpresaEntity empresa) {
		return this.empresaRepository.save(empresa);
	}
}