package com.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class VagaEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100)
	@NotNull
	private String descricao;
	
	private Double salario;
	
	@Column(length = 10)
	private String cargaHoraria;
	
	@NotNull
	private boolean isFinalizado;
	
	@NotNull
	@OneToOne
	private CargoEntity cargo;
	
	@NotNull
	@ManyToOne
	private EmpresaEntity empresa;
}