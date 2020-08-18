package com.skilldistillery.cebopets.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Cebopet;
import com.skilldistillery.cebopets.entities.Relationship;
import com.skilldistillery.cebopets.services.CebopetService;

@RestController
@RequestMapping("api")
public class CeboPetController {

	@Autowired
	private CebopetService serv;

	@GetMapping("cebopets/{cebopetId}")
	public Cebopet findByID(@PathVariable int cebopetId, Principal principal, HttpServletResponse res) {
		Cebopet cebopet;
		try {
			cebopet = serv.findCebopet(cebopetId, principal.getName());
			if (cebopet == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			cebopet = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return cebopet;
	}

	@GetMapping("cebopet/{cebopetId}/relationship")
	public Relationship findCeppetRelationship(@PathVariable int cebopetId, Principal principal,
			HttpServletResponse res) {
		Cebopet cebopet;
		try {
			cebopet = serv.findCebopet(cebopetId, principal.getName());
			if (cebopet == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			cebopet = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return cebopet.getRelationship();
	}

	@PostMapping("cebopets")
	public Cebopet createCebopet(@RequestBody Cebopet cebopet, Principal principal, HttpServletResponse res) {
		try {
			serv.createCebopet(cebopet, principal.getName());
			res.setStatus(201);
		} catch (Exception e) {
			res.setStatus(404);
			e.printStackTrace();
		}
		return cebopet;
	}
	
	@PutMapping("cebopets/{cebopetId}")
	public Cebopet updateCebopet(@PathVariable int cebopetId,@RequestBody Cebopet cebopet, Principal principal, HttpServletResponse res) {
		try {
			cebopet = serv.updateCebopet(cebopet, cebopetId, principal.getName());
			res.setStatus(200);
		} catch (Exception e) {
			cebopet = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return cebopet;
	}
	
	@PutMapping("cebopets/{cebopetId}/disable")
	public void disableCebopet(@PathVariable int cebopetId, Principal principal, HttpServletResponse res) {
		Cebopet cebopet = serv.findCebopet(cebopetId, principal.getName());
		cebopet.setEnabled(false);
		res.setStatus(204);
	}

}
