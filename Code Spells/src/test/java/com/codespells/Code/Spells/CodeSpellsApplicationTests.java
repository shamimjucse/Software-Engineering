package com.codespells.Code.Spells;

import com.codespells.Code.Spells.model.User;
import com.codespells.Code.Spells.repository.UserRepository;
import com.codespells.Code.Spells.service.UserServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeSpellsApplicationTests {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserServices userServices;

	@Test
	public void testFindByEmail() throws Exception {
		User user = new User();

		user.setId(1234);
		user.setEmail("xyz");
		user.setPassword("123");

		Mockito.when(userRepository.findByEmail("xyz")).thenReturn(user);

		User user1 = userRepository.findByEmail("xyz");

		Assert.assertNotEquals(null, user1.getId());
	}





}