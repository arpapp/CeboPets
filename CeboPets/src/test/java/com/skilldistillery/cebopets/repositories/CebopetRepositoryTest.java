package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.Cebopet;

@SpringBootTest
class CebopetRepositoryTest {
	
	@Autowired
	CebopetRepository ceboRepo;

	@Test
	void test_for_cebopet_by_id() {
		Optional <Cebopet> cebopetOpt = ceboRepo.findById(1);
		if (cebopetOpt != null) {
			Cebopet cebopet = cebopetOpt.get();
			
			assertNotNull(cebopet);
			assertEquals("StinkBobFartPants", cebopet.getName());
		}
	}

}
