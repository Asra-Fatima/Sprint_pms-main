package com.pms.in.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pms.in.entities.PensionDetails;
import com.pms.in.repository.PensionRepository;

@SpringBootTest
public class PensionServiceTests {

	@Autowired
	private PensionService pensionService;
	@MockBean
	private PensionRepository pensionRepository;

	@Test
	public void addPension() {

		PensionDetails pension = new PensionDetails(100, (double) 5000.00, (double) 500.00, "public", 10);
		when(pensionRepository.save(pension)).thenReturn(pension);
		assertEquals(pension, pensionService.addPensionDetails(pension));
	}

	@Test
	public void updatePension() {

		PensionDetails pension = new PensionDetails(100, (double) 6000.00, (double) 550.00, "private", 10);
		when(pensionRepository.save(pension)).thenReturn(pension);
		assertEquals(pension, pensionService.addPensionDetails(pension));
	}

	@Test
	public void deletePensionDetails() {
		PensionDetails pension = pensionRepository.getById(100);
		pensionRepository.delete(pension);
		Optional<PensionDetails> pensionOpt = Optional.empty();
		if (pensionOpt.isPresent()) {
			pension = pensionOpt.get();
		}
		Assertions.assertThat(pension).isNull();
	}
}
