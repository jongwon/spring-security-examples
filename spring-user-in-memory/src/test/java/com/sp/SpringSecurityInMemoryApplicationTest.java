package com.sp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringSecurityInMemoryApplicationTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void homePageLoad() throws Exception {

		mockMvc.perform(get("/home"))
				.andExpect(mvcResult -> {
					mvcResult.getResponse().getContentAsString()
							.contains("<h2> In memory User login Test Home Page </h2>");
				});

	}


	@Test
	public void loginSuccess() throws Exception {

		RequestBuilder requestBuilder = post("/login")
				.param("username", "jongwon")
				.param("password", "test")
				.param("_csrf", "ae3c3ff0-4946-4e94-b2f3-8268e6d4caa1");

		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(cookie().exists("JSESSIONID"));


		System.out.println("login success ... ");

	}

	@Test
	public void loginFailure() throws Exception {
		// test it

	}

	@Test
	public void loginAndLogoutSuccessfully() throws Exception {
		// test it

	}
}
