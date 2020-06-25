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
public class LoginEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 20, unique = true)
	@NotNull
	private String username;
	
	@Column(length = 20)
	@NotNull
	private String senha;	
}