package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDemo {

	private int id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	
}
