package com.skilldistillery.cebopets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.cebopets.entities.Post;


public interface PostRepository extends JpaRepository<Post, Integer>{
	
	Post findByIdAndUserUsername(int postId, String username);
	
	
}
