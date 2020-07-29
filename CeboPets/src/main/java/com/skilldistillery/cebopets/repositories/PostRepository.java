package com.skilldistillery.cebopets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.cebopets.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	Post findByIdAndCreatorUserUsername(int postId, String username);
	
	
}
