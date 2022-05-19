package com.onlystudy.blog.service;

import java.util.List;

import com.onlystudy.blog.model.Post;

public interface BlogService {

	List<Post> findAll();
	
	Post findById(long id);
	
	Post save(Post post);
	
	
}
