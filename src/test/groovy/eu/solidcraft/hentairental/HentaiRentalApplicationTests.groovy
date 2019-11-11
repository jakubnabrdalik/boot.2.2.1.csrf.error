package eu.solidcraft.hentairental

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class HentaiRentalApplicationTests {
	@Autowired MockMvc mockMvc

	@Test
	@WithMockUser
	void contextLoads() {
		mockMvc.perform(post("/points")
					.contentType(MediaType.APPLICATION_JSON)
					.content("""
						{				
						}
						""")
					.with(csrf()) //this line throws java.lang.NoClassDefFoundError: org.springframework.security.oauth2.jwt.Jwt$Builder
								  //if you do not add implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'
				)
				.andExpect(status().isOk())
	}

}
