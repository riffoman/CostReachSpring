package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.businessLogic.Utility;
import com.example.demo.dto.CategoriesDTO;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testUsersGetService() throws Exception {
		mockMvc.perform(get("/users")).andExpect(status().isOk())
				.andExpect(content().string(containsString("username")));
	}

	@Test
	public void testCategoriesGetService() throws Exception {
		mockMvc.perform(get("/categories")).andExpect(status().isOk());
	}

	@Test
	public void testCategoriesPostService() throws Exception {
		CategoriesDTO categoriesDTO = new CategoriesDTO();
		categoriesDTO.setName("Kategorija");
		categoriesDTO.setUserName("yufi");

		mockMvc.perform(post("/categories").contentType(MediaType.APPLICATION_JSON)
				.content(Utility.getObjectAsJSONString(categoriesDTO)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
