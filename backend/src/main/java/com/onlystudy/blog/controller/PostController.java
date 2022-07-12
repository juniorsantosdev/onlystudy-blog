package com.onlystudy.blog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.onlystudy.blog.dtos.PostDTO;
import com.onlystudy.blog.model.Post;
import com.onlystudy.blog.repository.BlogRepository;
import com.onlystudy.blog.service.BlogService;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostController {

	@Autowired
	private BlogRepository repository;

	@Autowired
	private BlogService service;
	
	/*@GetMapping
	public List<Post> obterTodos() {
		return repository.findAll();
	}*/
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll(){
		List<Post> list = service.findAll();
		List<PostDTO> lisDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDTO);
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
