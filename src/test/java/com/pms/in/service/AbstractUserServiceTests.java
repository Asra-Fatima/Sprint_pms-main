package com.pms.in.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pms.in.entities.AbstractUser;
import com.pms.in.repository.AbstractUserRepository;



@SpringBootTest
public class AbstractUserServiceTests {
	
	@MockBean
	private AbstractUserRepository repository;
	
	@Autowired
	private AbstractUserService service;
	

	@Test
	public void testRegister() {
		AbstractUser user = new AbstractUser((int)3,"admin","admin");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.register(user));
	}
	
}