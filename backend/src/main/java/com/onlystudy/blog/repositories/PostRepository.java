package com.onlystudy.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlystudy.blog.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
