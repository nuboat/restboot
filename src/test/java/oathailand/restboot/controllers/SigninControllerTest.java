package oathailand.restboot.controllers;

import lombok.extern.slf4j.Slf4j;
import oathailand.restboot.RESTApplication;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author pasoktummarungsri
 */
@Slf4j
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RESTApplication.class)
public class SigninControllerTest {

	protected MockMvc mvc;
	
	@Autowired
	protected WebApplicationContext wac;
	
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

	@Test
	public void testSigninCaseFail() throws Exception {
		final MockHttpServletRequestBuilder builder = 
			MockMvcRequestBuilders.post("/signin")
				.param("user", "norbor")
				.param("passwd", "pass");

        final ResultActions result = mvc.perform(builder)
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("false")));
	}
	
	@Test
	public void testSigninCaseSuccess() throws Exception {
		final MockHttpServletRequestBuilder builder = 
			MockMvcRequestBuilders.post("/signin")
				.param("user", "norbor")
				.param("passwd", "password");

        final ResultActions result = mvc.perform(builder)
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("true")));
	}
	
}
