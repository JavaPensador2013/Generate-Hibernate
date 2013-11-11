/**
 * <pre>
 * @author : eteixeira   
 * Purpose      :   Class used to ...
 * File Name    :   Pessoa.java
 * Package Name :   com.startapli.hibernate.entity
 * Project Name :   generate-hibernate
 *
 * Update Date  :   31/10/2013
 * Update Time  :   14:10:58
 *
 * Copyright 2013 JP Morgan
 * </pre>
 */
package br.com.startapli.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Person implements Serializable {

	private static final long serialVersionUID = -8165742448841006081L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	public Person(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Person() {

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
