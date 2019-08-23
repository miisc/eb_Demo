package com.demo.eb.entity;

import lombok.Data;

@Data
public class User {
	String id, username, password;
	boolean enabled;
}
