package com.sp;

import com.sp.domain.Role;
import com.sp.domain.User;
import com.sp.service.UserSecService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringSecurityMongoApplicationTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}


	@Test
	public void contextLoads() {

		User user = new User();
		user.setEmail("jongwon@test.com");
		user.setName("jongwon");
		user.setPassword(bCryptPasswordEncoder.encode("12345"));
		user.setEnabled(true);
		user.setExpired(false);
		user.setLocked(false);
		user.setCredentialExpired(false);
		user.setRoles(Sets.newSet(new Role("ADMIN")));

		wac.getBean(UserSecService.class).saveUser(user);

		System.out.println("hello jongwon");

	}

}
