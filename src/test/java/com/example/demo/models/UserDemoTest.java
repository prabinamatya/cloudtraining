package com.example.demo.models;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
