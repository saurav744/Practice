package com.saurav.myblogapp.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.saurav.myblogapp.model.User;
import com.saurav.myblogapp.model.UserType;
import com.saurav.myblogapp.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MyBlogAppController.class, secure = false)
public class MyBlogAppControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;
	
	User mockUser = new User("Simba", "Pumba", "lion@king", "HakunaMatata", UserType.BLOGGER );
	
	String userJson = "{\"firstName\": \"Simbha\",\"lastName\": \"Pumba\",\"email\": \"lion@king\",\"password\": \"HakunaMatata\",\"type\": \"BLOGGER\"}";
	
	@Test
	public void testGetUserById_001() throws Exception {
		
		Mockito.when(
				userService.getUserById(Mockito.anyLong())
				).thenReturn(mockUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/users/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "{id:1,firstName:Simbha,lastname:Pumba,email:lion@king}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void testCreateUser_002() throws Exception {
		
		//Mockito.when(userService.addUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any())).thenReturn(mockUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/users")
				.accept(MediaType.APPLICATION_JSON).content(userJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}


}
