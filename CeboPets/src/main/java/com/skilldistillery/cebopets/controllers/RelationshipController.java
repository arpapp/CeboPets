package com.skilldistillery.cebopets.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Relationship;
import com.skilldistillery.cebopets.services.RelationshipService;

@RestController
@RequestMapping("/api")
public class RelationshipController {

	@Autowired
	RelationshipService relServ;

	@GetMapping("/relationship/{relationshipId}")
	public Relationship relationshipGet(@PathVariable int relationshipId, HttpServletResponse res) {
		Relationship relationship = relServ.findById(relationshipId);
		if (relationship == null) {
			res.setStatus(404);
		}
		return relationship;
	}

	@PostMapping("/relationship")
	public Relationship makeNewRelationship(@RequestBody Relationship relationship, HttpServletResponse res,
			HttpServletRequest req) {
		try {
			relationship = relServ.createRelationship(relationship);
			if (relationship == null) {
				res.setStatus(400);
			} else {
				res.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(relationship.getId());
				res.setHeader("Location", url.toString());
			}
		} catch (Exception e) {
			res.setStatus(400);
			e.printStackTrace();
			relationship = null;
		}
		return relationship;
	}

	@PutMapping("/relationship/{relationshipId}")
	public Relationship changeRelationship(@RequestBody Relationship relationship, @PathVariable int relationshipId,
			HttpServletResponse res, HttpServletRequest req) {
		try {
			relationship = relServ.updateRelationship(relationshipId, relationship);
			if (relationship == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
			relationship = null;
		}
		return relationship;
	}

	@PutMapping("/relationship/{relationshipId}")
	public void updateRelationship(@RequestBody Relationship relationship, @PathVariable int relationshipId,
			HttpServletResponse res) {
		try {
			relServ.disableRelationship(relationshipId);
			if (relServ == null) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
	}
}
