package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserDemoTest {

	@Test
	public void getAndSets() {
		UserDemo userDemo = UserDemo.builder().id(1).name("brad").email("blv.moon@gmail.com").phone("309-319-6299")
				.username("bradmoon").website("google.com").build();

		assertEquals("brad", userDemo.getName());
		assertEquals(1, userDemo.getId());
		System.out.println(userDemo);
	}
}
