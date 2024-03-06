package com.denissmirnov.budgetcommander;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@AutoConfigureMockMvc
class BudgetCommanderApplicationTests  {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testLoginWithExistingData_1() throws Exception {
		byte[] jsonBytes = Files.readAllBytes(Paths.get("src/main/resources/static/Billy.json"));
		MockMultipartFile file = new MockMultipartFile(
				"file", "Billy.json", MediaType.APPLICATION_JSON_VALUE, jsonBytes);
		mockMvc.perform(MockMvcRequestBuilders.multipart("/auth/login")
				.file(file)
						.contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk());
	}

	@Test
	void testLoginWithNonExistingData_1() throws Exception {
		byte[] jsonBytes = Files.readAllBytes(Paths.get("src/main/resources/static/Billy.json"));

		String expectedJson = "{\n" +
				"    \"user\": null,\n" +
				"    \"jwt\": \"\"\n" +
				"}";

		MockMultipartFile file = new MockMultipartFile(
				"file", "John.json", MediaType.APPLICATION_JSON_VALUE, jsonBytes);
		mockMvc.perform(MockMvcRequestBuilders.multipart("/auth/login")
						.file(file)
						.contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpectAll(
						status().isOk(),
						content().string(expectedJson)
				);
	}

}
