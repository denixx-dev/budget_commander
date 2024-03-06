package com.denissmirnov.budgetcommander;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.is;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@AutoConfigureMockMvc
class BudgetCommanderApplicationTests  {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testLoginWithExistingData_1() throws Exception {
		String jsonContent = "{\n" +
				"  \"username\": \"Billy\",\n" +
				"  \"password\": \"123\"\n" +
				"}";

		mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonContent))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.user.userId").exists());
	}

	@Test
	void testLoginWithNonExistingData_1() throws Exception {
		String jsonContent = "{\n" +
				"  \"username\": \"John\",\n" +
				"  \"password\": \"123\"\n" +
				"}";

		mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonContent))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.jwt",  is("")));
	}

}
