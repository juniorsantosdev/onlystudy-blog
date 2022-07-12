package com.onlystudy.blog.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.onlystudy.blog.model.Post;


public class PostDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String autor;
	//private LocalDate data;
	//private String texto;
	
	public PostDTO() {
	}

	public PostDTO(Post obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		autor = obj.getAutor();
		//data = obj.getData();
		//texto = obj.getTexto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	//public LocalDate getData() {
	//	return data;
	//}

	//public void setData(LocalDate data) {
	//	this.data = data;
	//}

	//public String getTexto() {
	//	return texto;
	//}

	//public void setTexto(String texto) {
	//	this.texto = texto;
	//}
	
}
