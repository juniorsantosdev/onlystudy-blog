package com.onlystudy.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.onlystudy.blog.repository.BlogRepository;
import com.onlystudy.blog.model.Post;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostController {

	@Autowired
	private BlogRepository repository;

	@GetMapping
	public List<Post> obterTodos() {
		return repository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Post salvar(@RequestBody Post post) {
		return repository.save(post);
	}

	@GetMapping("{id}")
	public Post acharPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		repository.findById(id).map(post -> {
			repository.delete(post);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	/*@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Post postAtualizado) {
		repository.findById(id).map(post -> {
			post.setAutor(postAtualizado.getAutor());
			post.setTitulo(postAtualizado.getTitulo());
			post.setConteudo(postAtualizado.getConteudo());
			return repository.save(postAtualizado);

		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}*/

}
