package com.skilldistillery.cebopets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
