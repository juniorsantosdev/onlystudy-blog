package com.onlystudy.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlystudy.blog.model.Post;

public interface BlogRepository extends JpaRepository<Post, Long> {

}
