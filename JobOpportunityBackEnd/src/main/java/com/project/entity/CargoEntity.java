package com.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class CargoEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 100)
	@NotNull
	private String nome;
	
	@Column(length = 100)
	@NotNull
	private String descricao;
}