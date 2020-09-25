package com.skilldistillery.cebopets.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Breed;
import com.skilldistillery.cebopets.services.BreedService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4211"})
public class BreedController {

	@Autowired
	private BreedService breedServ;
	
	@GetMapping("/cebopets/{name}")
	public Breed getBreed(@PathVariable String name, HttpServletResponse res) {
		Breed breed;
		try {
			breed = breedServ.getBreedByName(name);
			if(breed == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			breed = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return breed;
	}
	
}
