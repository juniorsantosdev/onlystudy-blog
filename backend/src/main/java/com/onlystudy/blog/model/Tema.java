package com.onlystudy.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_tema;
	
	@Column
	private String nome;
	
	public Tema() {		
	}

	public Tema(Long id, String nome) {
		this.id_tema = id;
		this.nome = nome;
	}

	public Long getId() {
		return id_tema;
	}

	public void setId(Long id) {
		this.id_tema = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

