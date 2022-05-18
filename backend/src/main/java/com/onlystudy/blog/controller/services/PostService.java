package com.onlystudy.blog.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlystudy.blog.domain.Post;
import com.onlystudy.blog.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findByID(Long id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	public Post update(Long id, Post obj) {
		Post newObj = findByID(id);
		newObj.setAutor(obj.getAutor());
		newObj.setTexto(obj.getTexto());
		newObj.setTitulo(obj.getTitulo());		
		return postRepository.save(newObj);
	}
	
	public Post create(Post obj) {
		obj.setId(null);
		return postRepository.save(obj);
	}
}
