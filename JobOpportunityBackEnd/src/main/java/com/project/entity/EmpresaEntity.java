package com.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EmpresaEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100)
	@NotNull
	private String razaoSocial;
	
	@Column(length = 100)
	@NotNull
	private String nomeFantasia;
	
	@Column(length = 18)
	@NotNull
	private String cnpj;
	
	@NotNull
	private boolean isInativo;
	
	@NotNull
	@OneToOne
	private LoginEntity login;
	
	@NotNull
	@OneToOne
	private EnderecoEntity endereco;
}