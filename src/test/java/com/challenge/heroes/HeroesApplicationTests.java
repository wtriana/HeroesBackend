package com.challenge.heroes;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootTest
class HeroesApplicationTests {

	private HeroesApplication heroesApplication = new HeroesApplication();


	@Test
	void contextLoads() {
	}

	@Test
	public void testCorsConfig() {
		WebMvcConfigurer webMvcConfigurer = heroesApplication.corsConfigurer();
		Assert.assertNotNull(webMvcConfigurer);
		heroesApplication.corsConfigurer().addCorsMappings(new CorsRegistry());
	}

}
