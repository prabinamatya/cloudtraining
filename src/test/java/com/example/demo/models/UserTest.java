package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.models.User;
import org.junit.jupiter.api.Test;

public class UserTest {

	@Test
	public void getAndSets() {
		User user = User.builder().id(1).name("brad").email("blv.moon@gmail.com").phone("309-319-6299")
				.username("bradmoon").website("google.com").build();

		assertEquals("brad", user.getName());
		assertEquals(1, user.getId());
		System.out.println(user);
	}
}
