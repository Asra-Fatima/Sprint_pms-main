package com.pms.in.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pms.in.entities.PensionerDetails;
import com.pms.in.repository.PensionerRepository;

@SpringBootTest
public class PensionerServiceTests {

	@Autowired
	private PensionerService pensionerService;
	@MockBean
	private PensionerRepository pensionerRepository;

	@Test

	public void addPensioner() {

		PensionerDetails pensioner = new PensionerDetails(3, 21, 123, 897653, 20000, 1234, "self");
		when(pensionerRepository.save(pensioner)).thenReturn(pensioner);
		assertEquals(pensioner, pensionerService.addPensionerDetails(pensioner));
	}

	@Test
	public void updatePensioner() {

		PensionerDetails pensioner = new PensionerDetails(3, 21, 123, 897653, 20000, 123456, "private");
		when(pensionerRepository.save(pensioner)).thenReturn(pensioner);
		assertEquals(pensioner, pensionerService.addPensionerDetails(pensioner));
	}

	@Test
	public void deletePensionerDetails() {
		PensionerDetails pensioner = pensionerRepository.getById(2);
		pensionerRepository.delete(pensioner);
		Optional<PensionerDetails> pensionerOpt = Optional.empty();
		if (pensionerOpt.isPresent()) {
			pensioner = pensionerOpt.get();
		}
		Assertions.assertThat(pensioner).isNull();
	}

}