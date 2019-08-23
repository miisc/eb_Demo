package com.demo.eb.entity;

import lombok.Data;

@Data
public class System {
	int uid;
	String id, name;
	System superSystem;
}
