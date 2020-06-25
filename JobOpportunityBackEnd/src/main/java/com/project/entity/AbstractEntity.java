package com.project.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class AbstractEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
}